package com.obric.memorydata.awareness.impl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.dumper.Scraps;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.awareness.model.BluetoothDeviceInfo;
import com.obric.memorydata.utils.ao;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\"*\u0001\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J \u0010 \u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u000eH\u0003J\u0019\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000eH\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000eH\u0002J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0010\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0005H\u0002J\u001f\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0017\u00101\u001a\u0004\u0018\u00010\u000e2\u0006\u0010-\u001a\u00020\u0014H\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0014H\u0002J\u0010\u00104\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0014H\u0002J\u0010\u00105\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0014H\u0002J\u0012\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020\u0014H\u0002J\u0012\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020\u0014H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0014H\u0002J\u0010\u00109\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\u001a\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006="}, d2 = {"Lcom/obric/memorydata/awareness/impl/BluetoothBatteryManager;", "", "<init>", "()V", "TAG", "", "ACTION_BATTERY_LEVEL_CHANGED", "EXTRA_BATTERY_LEVEL", "isInitialized", "", "devices", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/sdk/awareness/model/BluetoothDeviceInfo;", "connectedAddressesByProfile", "", "", "hasBtConnectPermission", "context", "Landroid/content/Context;", "getDevice", "Landroid/bluetooth/BluetoothDevice;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "receiver", "com/obric/memorydata/awareness/impl/BluetoothBatteryManager$receiver$1", "Lcom/obric/memorydata/awareness/impl/BluetoothBatteryManager$receiver$1;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "syncConnectedDevices", "syncBondedConnectedNonAudioDevices", "handleBondStateChanged", "syncConnectedAudioDevices", "handleProfileConnectionChanged", "profile", "profileForAction", "action", "(Ljava/lang/String;)Ljava/lang/Integer;", "profileName", "profileStateName", "state", "bondStateName", "connectedAddresses", "isConnectedToAudioProfile", MemoryKeyInfoEntity.KEY_ADDRESS, "upsertDevice", "device", Scraps.BATTERY, "(Landroid/bluetooth/BluetoothDevice;Ljava/lang/Integer;)Z", "updateBatteryLevel", "getBatteryLevel", "(Landroid/bluetooth/BluetoothDevice;)Ljava/lang/Integer;", "isNonAudioDevice", "isBonded", "isConnected", "safeName", "safeAddress", "deviceLogKey", "maskAddress", "updateFeature", InfoRequestQPSOptTraceLogger.REASON, "stateOnly", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8691a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f8692b;
    private static final ConcurrentHashMap<String, BluetoothDeviceInfo> c = null;
    private static final ConcurrentHashMap<Integer, Set<String>> d = null;
    private static final a e = null;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, d2 = {"com/obric/memorydata/awareness/impl/BluetoothBatteryManager$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends PluginBroadcastReceiver {
        a() {
        }

        public void onReceive(Context r18, Intent r19) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r19, MemorySourceLinkType.INTENT);
            String r3 = r19.getAction();
            if (r3 == null) goto L113;
            boolean r9 = true;
            switch(r3.hashCode()) {
                case -1765714821: goto L100;
                case -1530327060: goto L86;
                case -612790895: goto L83;
                case -301431627: goto L65;
                case 545516589: goto L62;
                case 579327048: goto L46;
                case 1244161670: goto L43;
                case 1821585647: goto L12;
                case 2116862345: goto L8;
                default: goto L122;
            };
        L122:
            return;
        L8:
            if (r3.equals("android.bluetooth.device.action.BOND_STATE_CHANGED") == false) goto L123;
            h.b(h.f8691a, r1, r19);
            return;
        L123:
            return;
        L12:
            if (r3.equals("android.bluetooth.device.action.ACL_DISCONNECTED") == false) goto L124;
            BluetoothDevice r0 = h.a(h.f8691a, r1, r19);
            if (r0 != null) goto L17;
            return;
        L17:
            String r2 = h.a(h.f8691a, r0);
            if (r2 != null) goto L21;
            return;
        L21:
            if (h.b(h.f8691a, r2) == false) goto L24;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "收到 ACL 断链但仍有音频 Profile 连接，保留设备状态，" + h.d(h.f8691a, r0), false, 4, null);
            return;
        L24:
            Collection r4 = h.c().values();
            Intrinsics.checkNotNullExpressionValue(r4, "<get-values>(...)");
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
            if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L27;
            int r6 = 0;
        L36:
            if (h.b().remove(r2) != null) goto L39;
            r9 = false;
        L39:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "收到 ACL 断链，是否从特征移除设备=" + r9 + "，清理的 Profile 数量=" + r6 + 65292 + h.d(h.f8691a, r0), false, 4, null);
            if (r9 == false) goto L115;
            h r7 = h.f8691a;
            String r8 = "设备 ACL 断链";
        L81:
            h.a(r7, r8, false, 2, null);
            return;
        L115:
            return;
        L27:
            Iterator r10 = r5.iterator();
            r6 = 0;
        L29:
            if (r10.hasNext() == false) goto L36;
            if (((Set) ZeusTransformUtils.preCheckCast(r10.next(), Set.class, "com.obric.memorydata.plugin")).remove(r2) == false) goto L29;
            r6 = r6 + 1;
            if (r6 >= 0) goto L29;
            CollectionsKt.throwCountOverflow();
            goto L29
        L124:
            return;
        L43:
            if (r3.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED") == false) goto L125;
        L102:
            Integer r11 = h.a(h.f8691a, r19.getAction());
            if (r11 == null) goto L121;
            h.a(h.f8691a, r1, r19, r11.intValue());
            return;
        L121:
            return;
        L125:
            return;
        L46:
            if (r3.equals("android.bluetooth.device.action.BATTERY_LEVEL_CHANGED") == false) goto L126;
            BluetoothDevice r12 = h.a(h.f8691a, r1, r19);
            if (r12 != null) goto L51;
            return;
        L51:
            int r13 = r19.getIntExtra("android.bluetooth.device.extra.BATTERY_LEVEL", -1);
            if (r13 >= 0) goto L54;
        L56:
            r9 = false;
        L57:
            if (r9 == true) goto L59;
            return;
        L59:
            if (h.a(h.f8691a, r12, r13) == false) goto L117;
            RunLog.INSTANCE.debug("BluetoothBatteryManager", "已连接设备电量变化，电量=" + r13 + 65292 + h.d(h.f8691a, r12));
            r7 = h.f8691a;
            r8 = "已连接设备电量变化";
            goto L81
        L117:
            return;
        L54:
            if (r13 >= 101) goto L56;
        L126:
            return;
        L62:
            if (r3.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") == true) goto L102;
            return;
        L65:
            if (r3.equals("android.bluetooth.device.action.ACL_CONNECTED") == false) goto L128;
            BluetoothDevice r14 = h.a(h.f8691a, r1, r19);
            if (r14 != null) goto L71;
            return;
        L71:
            if (h.c(h.f8691a, r14) == true) goto L75;
            RunLog.INSTANCE.debug("BluetoothBatteryManager", "收到音频设备 ACL 建链，等待 Profile 确认连接，不更新特征，" + h.d(h.f8691a, r14));
            return;
        L75:
            if (h.e(h.f8691a, r14) == true) goto L78;
            RunLog.INSTANCE.debug("BluetoothBatteryManager", "收到未配对设备 ACL 建链，不视为真实连接，" + h.d(h.f8691a, r14));
            return;
        L78:
            boolean r15 = h.a(h.f8691a, r14, h.b(h.f8691a, r14));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "收到已配对非音频设备 ACL 建链，是否新增或更新设备=" + r15 + 65292 + h.d(h.f8691a, r14), false, 4, null);
            if (r15 == false) goto L118;
            r7 = h.f8691a;
            r8 = "已配对非音频设备 ACL 建链";
            goto L81
        L118:
            return;
        L128:
            return;
        L83:
            if (r3.equals("android.bluetooth.hearingaid.profile.action.CONNECTION_STATE_CHANGED") == true) goto L102;
            return;
        L86:
            if (r3.equals("android.bluetooth.adapter.action.STATE_CHANGED") == false) goto L130;
            int r16 = r19.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            if (r16 != 13) goto L91;
            boolean r17 = true;
        L93:
            if (r16 == 10) goto L96;
            r9 = false;
        L96:
            if (r17 == true) goto L98;
            if (r9 == true) goto L98;
            return;
        L98:
            int r20 = h.b().size();
            h.c().clear();
            h.b().clear();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "蓝牙正在关闭，清空已确认连接的设备，移除数量=" + r20, false, 4, null);
            r7 = h.f8691a;
            r8 = "蓝牙关闭";
            goto L81
        L91:
            r17 = false;
            goto L93
        L130:
            return;
        L100:
            if (r3.equals("android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED") == true) goto L102;
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/awareness/impl/BluetoothBatteryManager$syncConnectedAudioDevices$listener$1", "Landroid/bluetooth/BluetoothProfile$ServiceListener;", "onServiceConnected", "", "profile", "", "proxy", "Landroid/bluetooth/BluetoothProfile;", "onServiceDisconnected", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements BluetoothProfile.ServiceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BluetoothAdapter f8693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap.KeySetView<Integer, Boolean> f8694b;

        b(BluetoothAdapter r1, ConcurrentHashMap.KeySetView<Integer, Boolean> r2) {
            this.f8693a = r1;
            this.f8694b = r2;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r10, BluetoothProfile r11) {
            BluetoothProfile r12 = (BluetoothProfile) ZeusTransformUtils.wrapperContextForParams(r11, BluetoothProfile.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "proxy");
            Set r0 = h.a(h.f8691a, r10);     // Catch: Throwable -> L12 SecurityException -> L14
            r0.clear();     // Catch: Throwable -> L12 SecurityException -> L14
            List<BluetoothDevice> r2 = r12.getConnectedDevices();     // Catch: Throwable -> L12 SecurityException -> L14
            Intrinsics.checkNotNullExpressionValue(r2, "getConnectedDevices(...)");     // Catch: Throwable -> L12 SecurityException -> L14
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L12 SecurityException -> L14
        L5:
            if (r3.hasNext() == false) goto L10;
            BluetoothDevice r4 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(r3.next(), BluetoothDevice.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12 SecurityException -> L14
            h r5 = h.f8691a;     // Catch: Throwable -> L12 SecurityException -> L14
            Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L12 SecurityException -> L14
            String r6 = h.a(r5, r4);     // Catch: Throwable -> L12 SecurityException -> L14
            if (r6 == null) goto L9;
            r0.add(r6);     // Catch: Throwable -> L12 SecurityException -> L14
        L9:
            h.a(h.f8691a, r4, h.b(h.f8691a, r4));     // Catch: Throwable -> L12 SecurityException -> L14
            goto L5
        L10:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "音频 Profile 连接恢复完成，Profile=" + h.b(h.f8691a, r10) + "，连接数量=" + r0.size(), false, 4, null);     // Catch: Throwable -> L12 SecurityException -> L14
        L16:
            this.f8693a.closeProfileProxy(r10, r12);
            h.a(this.f8694b, r10);
            return;
        L12:
            th = move-exception;
            this.f8693a.closeProfileProxy(r10, r12);
            h.a(this.f8694b, r10);
            throw th;
        L14:
            e = move-exception;
            RunLog.INSTANCE.warn("BluetoothBatteryManager", "音频 Profile 连接恢复失败，系统拒绝蓝牙访问，Profile=" + h.b(h.f8691a, r10), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
            goto L16
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r8) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "恢复期间音频 Profile 服务断开，结束该 Profile 查询，Profile=" + h.b(h.f8691a, r8), null, 4, null);
            h.a(this.f8694b, r8);
        }
    }

    static {
        f8691a = new h();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new a();
    }

    private h() {
    }

    private final BluetoothDevice a(Context r7, Intent r8) {
        if (a((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin")) == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "收到蓝牙广播但缺少 BLUETOOTH_CONNECT 权限，忽略本次设备变化", null, 4, null);
        return null;
    L7:
        if (Build.VERSION.SDK_INT < 33) goto L9;
        Object r6 = r8.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);
    L11:
        return (BluetoothDevice) ZeusTransformUtils.preCheckCast(r6, BluetoothDevice.class, "com.obric.memorydata.plugin");
    L9:
        r6 = r8.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        goto L11
    }

    public static final /* synthetic */ BluetoothDevice a(h r2, Context r3, Intent r4) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final BluetoothDeviceInfo a(int r8, Ref.BooleanRef r9, String r10, BluetoothDeviceInfo r11) {
        Intrinsics.checkNotNullParameter(r10, "<unused var>");
        Intrinsics.checkNotNullParameter(r11, "info");
        Integer r12 = r11.getBatteryLevel();
        if (r12 != null) goto L6;
    L8:
        r9.element = true;
        return BluetoothDeviceInfo.copy$default(r11, null, null, Integer.valueOf(r8), 0, 0, 27, null);
    L6:
        if (r12.intValue() != r8) goto L8;
        return r11;
    }

    private static final BluetoothDeviceInfo a(Function2 r2, Object r3, Object r4) {
        return (BluetoothDeviceInfo) ZeusTransformUtils.preCheckCast(((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4), BluetoothDeviceInfo.class, "com.obric.memorydata.plugin");
    }

    private static final Comparable a(BluetoothDeviceInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.getName(), Comparable.class, "com.obric.memorydata.plugin");
    }

    private final Integer a(BluetoothDevice r10) {
        Method[] r2 = BluetoothDevice.class.getMethods();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r2, "getMethods(...)");     // Catch: Throwable -> L28
        Object[] r3 = (Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        int r4 = r3.length;     // Catch: Throwable -> L28
        boolean r5 = false;
        int r6 = 0;
    L4:
        if (r6 >= r4) goto L9;
        Object r7 = r3[r6];     // Catch: Throwable -> L28
        if (Intrinsics.areEqual(((Method) ZeusTransformUtils.preCheckCast(r7, Method.class, "com.obric.memorydata.plugin")).getName(), "getBatteryLevel") == true) goto L10;
        r6 = r6 + 1;     // Catch: Throwable -> L28
    L10:
        Method r8 = (Method) ZeusTransformUtils.preCheckCast(r7, Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r8 == null) goto L13;
        Object r9 = r8.invoke(r10, new Object[0]);     // Catch: Throwable -> L28
    L15:
        if (ZeusTransformUtils.instanceOf(r9, Integer.class) == false) goto L17;
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r9, Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
    L18:
        if (r0 == null) goto L27;
        int r1 = r0.intValue();     // Catch: Throwable -> L28
        if (r1 >= 0) goto L22;
    L24:
        if (r5 == false) goto L35;
        return Integer.valueOf(r1);
    L35:
        return null;
    L22:
        if (r1 >= 101) goto L24;
        r5 = true;
        goto L24
    L27:
        return null;
    L17:
        r0 = null;
        goto L18
    L13:
        r9 = null;
        goto L15
    L9:
        r7 = null;
    L28:
        th = move-exception;
        RunLog.INSTANCE.error("BluetoothBatteryManager", "读取蓝牙设备电量失败，" + g(r10), th);
        return null;
    }

    public static final /* synthetic */ Integer a(h r0, String r1) {
        return r0.a(r1);
    }

    private final Integer a(String r1) {
        if (r1 != null) goto L4;
    L23:
        return null;
    L4:
        switch(r1.hashCode()) {
            case -1765714821: goto L19;
            case -612790895: goto L15;
            case 545516589: goto L11;
            case 1244161670: goto L7;
            default: goto L23;
        };
    L7:
        if (r1.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED") == false) goto L23;
        int r0 = 2;
    L25:
        return Integer.valueOf(r0);
    L11:
        if (r1.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") == false) goto L23;
        r0 = 1;
        goto L25
    L15:
        if (r1.equals("android.bluetooth.hearingaid.profile.action.CONNECTION_STATE_CHANGED") == false) goto L23;
        r0 = 21;
        goto L25
    L19:
        if (r1.equals("android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED") == false) goto L23;
        r0 = 22;
        goto L25
    }

    private final String a(int r1) {
        if (r1 != 1) goto L5;
        return "headset";
    L5:
        if (r1 != 2) goto L7;
        return "a2dp";
    L7:
        if (r1 != 21) goto L9;
        return "hearing_aid";
    L9:
        if (r1 != 22) goto L16;
        return "le_audio";
    L16:
        return String.valueOf(r1);
    }

    public static final /* synthetic */ String a(h r0, BluetoothDevice r1) {
        return r0.f(r1);
    }

    public static final /* synthetic */ Set a(h r0, int r1) {
        return r0.d(r1);
    }

    private static final Set a(Integer r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Set) ZeusTransformUtils.preCheckCast(ConcurrentHashMap.newKeySet(), Set.class, "com.obric.memorydata.plugin");
    }

    private static final Set a(Function1 r2, Object r3) {
        return (Set) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Set.class, "com.obric.memorydata.plugin");
    }

    private final void a(Context r19, Intent r20, int r21) {
        BluetoothDevice r3 = a((Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin"), r20);
        if (r3 != null) goto L5;
        return;
    L5:
        String r5 = f(r3);
        if (r5 != null) goto L8;
        return;
    L8:
        Set<String> r6 = d(r21);
        int r1 = r20.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "收到音频 Profile 状态变化，Profile=" + a(r21) + "，状态=" + b(r1) + '(' + r1 + ")，" + g(r3), false, 4, null);
        if (r1 == 0) goto L16;
        if (r1 != 2) goto L28;
        boolean r2 = r6.add(r5);
        boolean r7 = a(r3, a(r3));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "音频 Profile 已连接，是否首次记录该 Profile=" + r2 + "，是否新增或更新设备=" + r7 + 65292 + g(r3), false, 4, null);
        if (r7 == false) goto L25;
        StringBuilder r4 = new StringBuilder().append("音频 Profile ").append(a(r21));
        String r8 = " 已连接";
    L15:
        a(this, r4.append(r8).toString(), false, 2, null);
        return;
    L25:
        return;
    L28:
        return;
    L16:
        boolean r9 = r6.remove(r5);
        boolean r10 = b(r5);
        if (r10 == false) goto L19;
    L21:
        boolean r11 = false;
    L22:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "音频 Profile 已断开，是否清除该 Profile 连接=" + r9 + "，是否仍有其他 Profile 连接=" + r10 + "，是否从特征移除设备=" + r11 + 65292 + g(r3), false, 4, null);
        if (r11 == false) goto L27;
        r4 = new StringBuilder().append("音频 Profile ").append(a(r21));
        r8 = " 已断开";
        goto L15
    L27:
        return;
    L19:
        if (c.remove(r5) == null) goto L21;
        r11 = true;
        goto L22
    }

    public static final /* synthetic */ void a(h r2, Context r3, Intent r4, int r5) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    static /* synthetic */ void a(h r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.a(r1, r2);
    }

    private final void a(String r8, boolean r9) {
        Collection<BluetoothDeviceInfo> r7 = c.values();
        Intrinsics.checkNotNullExpressionValue(r7, "<get-values>(...)");
        List r10 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{$$Lambda$h$xDxP0b17YoimKb4sIc20Tg0QVgw.INSTANCE, $$Lambda$h$smjbr5qELEHCRFhzrV_TCyfUUY.INSTANCE}));
        if (r9 == false) goto L5;
        String r0 = "只恢复状态";
    L6:
        if (r9 == false) goto L8;
        Map<String, ? extends Object> r11 = MapsKt.mapOf(TuplesKt.to("feature_event_mode", "state_only"));
    L9:
        FeatureManager.INSTANCE.setFeature("connect_bluetooth_devices", r10, r11);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "写入 CONNECT_BLUETOOTH_DEVICES 特征，触发场景=" + r8 + "，事件策略=" + r0 + "，设备数量=" + r10.size(), false, 4, null);
        RunLog.INSTANCE.debug("BluetoothBatteryManager", "当前确认连接的设备数量=" + r10.size());
        return;
    L8:
        r11 = null;
        goto L9
    L5:
        r0 = "按变化判断";
        goto L6
    }

    public static final /* synthetic */ void a(ConcurrentHashMap.KeySetView r0, int r1) {
        b(r0, r1);
    }

    private final boolean a(BluetoothDevice r3, final int r4) {
        String r2 = f(r3);
        if (r2 != null) goto L6;
        return false;
    L6:
        final Ref.BooleanRef r5 = new Ref.BooleanRef();
        ConcurrentHashMap<String, BluetoothDeviceInfo> r0 = c;
        final Function2 r1 = new $$Lambda$h$2YjXdr2juMHnpT8wLwBdmDanPo(r4, r5);
        r0.computeIfPresent(r2, new $$Lambda$h$UVU9ujb9WgcyoGmyKmBtZWzI0QQ(r1));
        return r5.element;
    }

    private final boolean a(BluetoothDevice r8, Integer r9) {
        String r6 = f(r8);
        if (r6 != null) goto L6;
        return false;
    L6:
        String r7 = e(r8);
        if (r7 != null) goto L9;
        r7 = "Unknown";
    L9:
        String r1 = r7;
        BluetoothClass r10 = r8.getBluetoothClass();     // Catch: SecurityException -> L12
    L14:
        if (r10 == null) goto L16;
        int r4 = r10.getDeviceClass();
    L17:
        if (r10 == null) goto L19;
        int r5 = r10.getMajorDeviceClass();
    L20:
        BluetoothDeviceInfo r11 = new BluetoothDeviceInfo(r1, r6, r9, r4, r5);
        return !Intrinsics.areEqual(c.put(r6, r11), r11);
    L19:
        r5 = -1;
        goto L20
    L16:
        r4 = -1;
    L12:
        r10 = null;
        goto L14
    }

    private final boolean a(Context r2) {
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "android.permission.BLUETOOTH_CONNECT") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ boolean a(h r0, BluetoothDevice r1, int r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean a(h r0, BluetoothDevice r1, Integer r2) {
        return r0.a(r1, r2);
    }

    private static final Comparable b(BluetoothDeviceInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.getAddress(), Comparable.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Integer b(h r0, BluetoothDevice r1) {
        return r0.a(r1);
    }

    private final String b(int r1) {
        if (r1 != 0) goto L4;
        return "已断开";
    L4:
        if (r1 != 1) goto L6;
        return "连接中";
    L6:
        if (r1 != 2) goto L8;
        return "已连接";
    L8:
        if (r1 == 3) goto L10;
        return "未知";
    L10:
        return "断开中";
    }

    public static final /* synthetic */ String b(h r0, int r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ ConcurrentHashMap b() {
        return c;
    }

    private final void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        d();
        c(r4);
    }

    private final void b(Context r10, Intent r11) {
        BluetoothDevice r12 = a((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin"), r11);
        if (r12 != null) goto L6;
        return;
    L6:
        if (b(r12) == true) goto L9;
        RunLog.INSTANCE.debug("BluetoothBatteryManager", "收到音频设备配对状态变化，连接状态由 Profile 确认，忽略本次变化，" + g(r12));
        return;
    L9:
        int r13 = r11.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "收到非音频设备配对状态变化，配对状态=" + c(r13) + '(' + r13 + ")，" + g(r12), false, 4, null);
        if (r13 != 10) goto L12;
        String r14 = f(r12);
        if (r14 != null) goto L24;
        return;
    L24:
        if (b(r14) == false) goto L26;
        return;
    L26:
        if (c.remove(r14) == null) goto L32;
        String r15 = "非音频设备解除配对";
    L19:
        a(this, r15, false, 2, null);
        return;
    L32:
        return;
    L12:
        if (r13 == 12) goto L15;
        return;
    L15:
        if (d(r12) == true) goto L17;
        return;
    L17:
        if (a(r12, a(r12)) == false) goto L29;
        r15 = "非音频设备配对完成且保持连接";
        goto L19
    }

    public static final /* synthetic */ void b(h r2, Context r3, Intent r4) {
        r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final void b(ConcurrentHashMap.KeySetView<Integer, Boolean> r6, int r7) {
        if (r6.remove(Integer.valueOf(r7)) == true) goto L5;
        return;
    L5:
        if (r6.isEmpty() == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "所有音频 Profile 查询完成，以恢复后的设备快照建立基线", false, 4, null);
        f8691a.a("启动音频 Profile 恢复完成", true);
        return;
    }

    private final boolean b(BluetoothDevice r1) {
        Integer r0 = null;
        BluetoothClass r2 = r1.getBluetoothClass();     // Catch: SecurityException -> L12
        if (r2 == null) goto L6;
        r0 = Integer.valueOf(r2.getMajorDeviceClass());     // Catch: SecurityException -> L12
    L6:
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.intValue() == 1024) goto L10;
        return true;
    }

    public static final /* synthetic */ boolean b(h r0, String r1) {
        return r0.b(r1);
    }

    private final boolean b(String r5) {
        Collection<Set<String>> r4 = d.values();
        Intrinsics.checkNotNullExpressionValue(r4, "<get-values>(...)");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L15;
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L16;
        if (((Set) ZeusTransformUtils.preCheckCast(r7.next(), Set.class, "com.obric.memorydata.plugin")).contains(r5) == false) goto L7;
        return true;
    L16:
        return false;
    L15:
        return false;
    }

    private final String c(int r1) {
        switch(r1) {
            case 10: goto L6;
            case 11: goto L5;
            case 12: goto L4;
            default: goto L3;
        };
    L3:
        return "未知";
    L4:
        return "已配对";
    L5:
        return "配对中";
    L6:
        return "未配对";
    }

    private final String c(String r2) {
        return "**:**:**:**:" + StringsKt.takeLast(r2, 5);
    }

    public static final /* synthetic */ ConcurrentHashMap c() {
        return d;
    }

    private final void c(Context r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L6;
        h r12 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "启动恢复音频设备失败，系统蓝牙适配器不可用，以当前快照建立基线", null, 4, null);
        r12.a("启动恢复时蓝牙适配器不可用", true);
        return;
    L6:
        List r15 = CollectionsKt.mutableListOf(new Integer[]{2, 1, 21});
        if (Build.VERSION.SDK_INT < 33) goto L9;
        r15.add(22);
    L9:
        ConcurrentHashMap.KeySetView r2 = ConcurrentHashMap.newKeySet();
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin"));
        b r3 = new b(r0, r2);
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r16.hasNext() == false) goto L15;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r16.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r0.getProfileProxy(r14, (BluetoothProfile.ServiceListener) ZeusTransformUtils.preCheckCast(r3, BluetoothProfile.ServiceListener.class, "com.obric.memorydata.plugin"), r4) == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "无法获取音频 Profile 服务，跳过该 Profile 恢复，Profile=" + f8691a.a(r4), null, 4, null);
        b(r2, r4);
        goto L11
    }

    private final boolean c(BluetoothDevice r2) {
        if (r2.getBondState() != 12) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public static final /* synthetic */ boolean c(h r0, BluetoothDevice r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ String d(h r0, BluetoothDevice r1) {
        return r0.g(r1);
    }

    private final Set<String> d(int r3) {
        ConcurrentHashMap<Integer, Set<String>> r2 = d;
        Integer r4 = Integer.valueOf(r3);
        final $$Lambda$h$KR1v91oCNqo6b8II3qvsWwySNo r0 = $$Lambda$h$KR1v91oCNqo6b8II3qvsWwySNo.INSTANCE;
        Set<String> r5 = r2.computeIfAbsent(r4, new $$Lambda$h$RUGZOmilA_4CeAF6oyon_0eZ3rA(r0));
        Intrinsics.checkNotNullExpressionValue(r5, "computeIfAbsent(...)");
        return (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.memorydata.plugin");
    }

    private final void d() {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L6;
        h r8 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "启动恢复非音频设备失败，系统蓝牙适配器不可用", null, 4, null);
        return;
    L6:
        int r9 = 0;
        Set<BluetoothDevice> r1 = r0.getBondedDevices();     // Catch: SecurityException -> L21
        if (r1 == null) goto L19;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: SecurityException -> L21
    L11:
        if (r2.hasNext() == false) goto L19;
        BluetoothDevice r3 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(r2.next(), BluetoothDevice.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L21
        h r4 = f8691a;     // Catch: SecurityException -> L21
        Intrinsics.checkNotNull(r3);     // Catch: SecurityException -> L21
        if (r4.b(r3) == false) goto L11;
        if (r4.d(r3) == false) goto L11;
        if (r4.a(r3, r4.a(r3)) == false) goto L11;
        r9 = r9 + 1;     // Catch: SecurityException -> L21
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "启动恢复非音频设备完成，恢复数量=" + r9, false, 4, null);     // Catch: SecurityException -> L21
        return;
    L21:
        e = move-exception;
        RunLog.INSTANCE.warn("BluetoothBatteryManager", "启动恢复已配对非音频设备失败，系统拒绝蓝牙访问", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final boolean d(BluetoothDevice r3) {
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(ao.call(r3, "isConnected", new Object[0]), Boolean.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L7
        if (r4 == null) goto L10;
        return r4.booleanValue();
    L10:
        return false;
    L11:
        return false;
    }

    private final String e(BluetoothDevice r1) {
        return r1.getName();
    L4:
        return null;
    }

    public static final /* synthetic */ boolean e(h r0, BluetoothDevice r1) {
        return r0.c(r1);
    }

    private final String f(BluetoothDevice r1) {
        return r1.getAddress();
    L4:
        return null;
    }

    private final String g(BluetoothDevice r2) {
        String r3 = f(r2);
        if (r3 == null) goto L6;
        String r1 = c(r3);
        if (r1 == null) goto L6;
    L8:
        return "设备地址=" + r1;
    L6:
        r1 = "未知";
        goto L8
    }

    /* JADX INFO: renamed from: lambda$2YjXdr2juMHn-pT8wLwBdmDanPo, reason: not valid java name */
    public static /* synthetic */ BluetoothDeviceInfo m518lambda$2YjXdr2juMHnpT8wLwBdmDanPo(int r0, Ref.BooleanRef r1, String r2, BluetoothDeviceInfo r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$KR1-v91oCNqo6b8II3qvsWwySNo, reason: not valid java name */
    public static /* synthetic */ Set m519lambda$KR1v91oCNqo6b8II3qvsWwySNo(Integer r0) {
        return a(r0);
    }

    public static /* synthetic */ Set lambda$RUGZOmilA_4CeAF6oyon_0eZ3rA(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ BluetoothDeviceInfo lambda$UVU9ujb9WgcyoGmyKmBtZWzI0QQ(Function2 r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$smjbr5qELEHCRFhzrV_-TCyfUUY, reason: not valid java name */
    public static /* synthetic */ Comparable m520lambda$smjbr5qELEHCRFhzrV_TCyfUUY(BluetoothDeviceInfo r0) {
        return b(r0);
    }

    public static /* synthetic */ Comparable lambda$xDxP0b17YoimKb4sIc20Tg0QVgw(BluetoothDeviceInfo r0) {
        return a(r0);
    }

    public final void a() {
        if (f8692b == false) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        r2.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        r2.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        r2.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        r2.addAction("android.bluetooth.hearingaid.profile.action.CONNECTION_STATE_CHANGED");
        if (Build.VERSION.SDK_INT < 33) goto L8;
        r2.addAction("android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED");
    L8:
        r2.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        r2.addAction("android.bluetooth.device.action.BATTERY_LEVEL_CHANGED");
        r2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        ZeusTransformUtils.registerReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(e, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r2, "com.obric.memorydata.plugin");
        f8692b = true;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "蓝牙连接状态监听注册完成，开始恢复当前已连接设备", false, 4, null);
        Intrinsics.checkNotNull(r0);
        if (a(r0) == false) goto L11;
        b(r0);
        return;
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BluetoothBatteryManager", "缺少 BLUETOOTH_CONNECT 权限，跳过启动连接恢复并建立空基线", false, 4, null);
        a("启动恢复缺少蓝牙权限", true);
    }
}
