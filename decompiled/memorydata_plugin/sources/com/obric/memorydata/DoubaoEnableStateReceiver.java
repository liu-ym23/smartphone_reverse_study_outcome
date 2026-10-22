package com.obric.memorydata;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.EntityManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/DoubaoEnableStateReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "handlePackageChanged", "checkIsValidEnableStateChange", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DoubaoEnableStateReceiver extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8292a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/DoubaoEnableStateReceiver$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8292a = new a(null);
    }

    public DoubaoEnableStateReceiver() {
    }

    private static final Unit a(Context r9, DoubaoEnableStateReceiver r10, Intent r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        ApplicationInfo r13 = r12.getPackageManager().getApplicationInfo(r12.getPackageName(), 0);
        Intrinsics.checkNotNullExpressionValue(r13, "getApplicationInfo(...)");
        boolean r14 = r13.enabled;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DoubaoEnableStateReceiver", "isDoubaoEnabled: isEnabled=" + r14, false, 4, null);
        if (r14 == false) goto L10;
        if (r10.a(r11) == false) goto L10;
        if (EntityManager.INSTANCE.isInLaunchFirstMinute() == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DoubaoEnableStateReceiver", "set need_reindex_after_agree to true", false, 4, null);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(EntityManager.KEY_NEED_REINDEX_AFTER_AGREE, true);
    L10:
        return Unit.INSTANCE;
    }

    private final void a(Context r3, final Intent r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.d.a(new $$Lambda$DoubaoEnableStateReceiver$TPq5e5YhsS6CwO9bKVW_W213FI0(r5, this, r4));
    }

    private final boolean a(final Intent r2) {
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.d.a(new $$Lambda$DoubaoEnableStateReceiver$GzQv5PC3batmJuUy8ifbdZnFLw(r2)), Boolean.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }

    private static final boolean b(Intent r22) {
        Uri r1 = r22.getData();
        if (r1 == null) goto L5;
        String r2 = r1.getSchemeSpecificPart();
    L6:
        boolean r3 = r22.getBooleanExtra("android.intent.extra.DONT_KILL_APP", true);
        String[] r5 = r22.getStringArrayExtra("android.intent.extra.changed_component_name_list");
        Bundle r6 = r22.getExtras();
        if (r6 == null) goto L27;
        Set<String> r7 = r6.keySet();
        if (r7 == null) goto L27;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r8.hasNext() == false) goto L27;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        RunLog r10 = RunLog.INSTANCE;
        StringBuilder r11 = new StringBuilder().append("extra[").append(r9).append("] = ");
        Bundle r12 = r22.getExtras();
        if (r12 == null) goto L24;
        Object r13 = r12.get(r9);
        if (r13 == null) goto L24;
        if (ZeusTransformUtils.instanceOf(r13, Iterable.class) == false) goto L21;
        String r14 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L25:
        r10.debug("DoubaoEnableStateReceiver", r11.append(r14).toString());
        goto L12
    L21:
        if ((r13 instanceof Object[]) == false) goto L23;
        r14 = ArraysKt.joinToString$default((Object[]) ZeusTransformUtils.preCheckCast(r13, Object[].class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        goto L25
    L23:
        r14 = r13.toString();
    L24:
        r14 = null;
    L27:
        if (r3 == false) goto L30;
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("checkIsValidEnableStateChange: packageName=").append(r2).append(", dontKillApp=").append(r3);
        String r4 = ", is not enable app";
    L29:
        IRunLog.a.a(r15, "DoubaoEnableStateReceiver", r0.append(r4).toString(), false, 4, null);
        return false;
    L30:
        if (r5 != null) goto L32;
    L35:
        r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r0 = new StringBuilder().append("checkIsValidEnableStateChange: packageName=").append(r2).append(", dontKillApp=").append(r3).append(", changedComponentNameList=").append(r5);
        r4 = ", is not valid";
        goto L29
    L32:
        if (r5.length != 1) goto L35;
        if (Intrinsics.areEqual(r5[0], r2) == false) goto L35;
        return true;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$GzQv5PC3batmJuUy8ifbdZn-FLw, reason: not valid java name */
    public static /* synthetic */ boolean m428lambda$GzQv5PC3batmJuUy8ifbdZnFLw(Intent r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$TPq5e5YhsS6CwO9bKVW_W213FI0(Context r0, DoubaoEnableStateReceiver r1, Intent r2) {
        return a(r0, r1, r2);
    }

    public void onReceive(Context r10, Intent r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L16;
        if (r11 == null) goto L19;
        String r0 = r11.getAction();
        Uri r2 = r11.getData();
        if (r2 == null) goto L9;
        String r3 = r2.getSchemeSpecificPart();
    L11:
        if (Intrinsics.areEqual(r3, r12.getPackageName()) == false) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DoubaoEnableStateReceiver", "receive: action=" + r0 + ", packageName=" + r3 + ", uri=" + r11.getData(), false, 4, null);
        if (Intrinsics.areEqual(r0, "android.intent.action.PACKAGE_CHANGED") == false) goto L18;
        a(r12, r11);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r3 = null;
        goto L11
    L19:
        return;
    }
}
