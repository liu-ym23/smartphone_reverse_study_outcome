package com.obric.memorydata.middleware.impl.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J'\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/middleware/impl/bdtracker/NonSensitiveInfoProvider;", "Lcom/bytedance/bdinstall/ISstInfoProvider;", "<init>", "()V", "getMac", "", "context", "Landroid/content/Context;", "options", "Lcom/bytedance/bdinstall/InstallOptions;", "getDefaultImeiOrMeid", "getMeid", "slotIndex", "", "getImei", "reflectGetDeviceIdWithSlotIndex", "getSerial", "getSimSerialNumbers", "", "(Landroid/content/Context;Lcom/bytedance/bdinstall/InstallOptions;)[Ljava/lang/String;", "getIPV6Address", "Lorg/json/JSONArray;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements ISstInfoProvider {
    public c() {
    }

    @Override // com.bytedance.bdinstall.ISstInfoProvider
    public String getDefaultImeiOrMeid(Context r1, InstallOptions r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return "";
    }

    @Override // com.bytedance.bdinstall.ISstInfoProvider
    public JSONArray getIPV6Address(Context r21) {
        String r0 = "dummy0";
        String r1 = "iterator(...)";
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin");
        JSONArray r3 = new JSONArray();
    L61:
        e = move-exception;
        e.printStackTrace();
    L63:
        return r3;
    L4:
        if (NetworkInterface.getNetworkInterfaces() == null) goto L6;
        Iterator r4 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Exception -> L61
        Intrinsics.checkNotNullExpressionValue(r4, "iterator(...)");     // Catch: Exception -> L61
    L9:
        if (r4.hasNext() == false) goto L63;
        NetworkInterface r5 = (NetworkInterface) ZeusTransformUtils.preCheckCast(r4.next(), NetworkInterface.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L61
        String r6 = r5.getName();     // Catch: Exception -> L61
        if (Intrinsics.areEqual(r0, r6) == true) goto L16;
        if (Intrinsics.areEqual("wlan0", r6) == false) goto L9;
    L16:
        Iterator r7 = Collections.list(r5.getInetAddresses()).iterator();     // Catch: Exception -> L61
        Intrinsics.checkNotNullExpressionValue(r7, r1);     // Catch: Exception -> L61
    L18:
        if (r7.hasNext() == false) goto L9;
        String r8 = ((InetAddress) ZeusTransformUtils.preCheckCast(r7.next(), InetAddress.class, "com.obric.memorydata.plugin")).getHostAddress();     // Catch: Exception -> L61
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L18;
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L61
        if (StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), ':', 0, false, 6, null) >= 0) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == true) goto L18;
        int r10 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), '%', 0, false, 6, null);     // Catch: Exception -> L61
        if (Intrinsics.areEqual(r0, r6) == true) goto L29;
        String r16 = r0;
        if (Intrinsics.areEqual("wlan0", r6) == true) goto L53;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L61
        String r17 = r1;
        Iterator r18 = r4;
        List<String> r11 = new Regex("::").split(r12, 0);     // Catch: Exception -> L61
        if (r11.isEmpty() == true) goto L49;
        ListIterator<String> r13 = r11.listIterator(r11.size());     // Catch: Exception -> L61
    L41:
        if (r13.hasPrevious() == false) goto L49;
        Iterator r19 = r7;
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r13.previous(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L45;
        boolean r14 = true;
    L46:
        if (r14 == false) goto L47;
        r7 = r19;
        goto L41
    L47:
        List r15 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), r13.nextIndex() + 1);     // Catch: Exception -> L61
    L51:
        if (StringsKt.equals("fe80", ((String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"))[0], true) == true) goto L54;
    L60:
        r0 = r16;
        r1 = r17;
        r4 = r18;
        r7 = r19;
    L54:
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L61
        r20.put("type", "client_anpi");     // Catch: Exception -> L61
        if (r10 >= 0) goto L58;
        Locale r22 = Locale.getDefault();     // Catch: Exception -> L61
        Intrinsics.checkNotNullExpressionValue(r22, "getDefault(...)");     // Catch: Exception -> L61
        String r23 = r8.toUpperCase(r22);     // Catch: Exception -> L61
    L57:
        Intrinsics.checkNotNullExpressionValue(r23, "toUpperCase(...)");     // Catch: Exception -> L61
        r20.put(EventBody.KEY_VALUE, r23);     // Catch: Exception -> L61
        r3.put(r20);     // Catch: Exception -> L61
        goto L60
    L58:
        String r24 = r8.substring(0, r10);     // Catch: Exception -> L61
        Intrinsics.checkNotNullExpressionValue(r24, "substring(...)");     // Catch: Exception -> L61
        Locale r25 = Locale.getDefault();     // Catch: Exception -> L61
        Intrinsics.checkNotNullExpressionValue(r25, "getDefault(...)");     // Catch: Exception -> L61
        r23 = r24.toUpperCase(r25);     // Catch: Exception -> L61
        goto L57
    L45:
        r14 = false;
    L49:
        r19 = r7;
        r15 = CollectionsKt.emptyList();     // Catch: Exception -> L61
        goto L51
    L53:
        r17 = r1;
        r18 = r4;
        r19 = r7;
        goto L54
    L29:
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L61
        String r111 = r0;
        r110.put("type", "client_tun");     // Catch: Exception -> L61
        if (r10 >= 0) goto L33;
        Locale r26 = Locale.getDefault();     // Catch: Exception -> L61
        Intrinsics.checkNotNullExpressionValue(r26, "getDefault(...)");     // Catch: Exception -> L61
        String r27 = r8.toUpperCase(r26);     // Catch: Exception -> L61
    L32:
        Intrinsics.checkNotNullExpressionValue(r27, "toUpperCase(...)");     // Catch: Exception -> L61
        r110.put(EventBody.KEY_VALUE, r27);     // Catch: Exception -> L61
        r3.put(r110);     // Catch: Exception -> L61
        r0 = r111;
        goto L18
    L33:
        String r28 = r8.substring(0, r10);     // Catch: Exception -> L61
        Intrinsics.checkNotNullExpressionValue(r28, "substring(...)");     // Catch: Exception -> L61
        Locale r29 = Locale.getDefault();     // Catch: Exception -> L61
        Intrinsics.checkNotNullExpressionValue(r29, "getDefault(...)");     // Catch: Exception -> L61
        r27 = r28.toUpperCase(r29);     // Catch: Exception -> L61
        goto L32
    L24:
        r9 = false;
        goto L25
    L6:
        return new JSONArray();
    }

    @Override // com.bytedance.bdinstall.ISstInfoProvider
    public String getImei(Context r1, int r2, InstallOptions r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return "";
    }

    @Override // com.bytedance.bdinstall.ISstInfoProvider
    public String getMac(Context r1, InstallOptions r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return "";
    }

    @Override // com.bytedance.bdinstall.ISstInfoProvider
    public String getMeid(Context r1, int r2, InstallOptions r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return "";
    }

    @Override // com.bytedance.bdinstall.ISstInfoProvider
    public String getSerial(Context r1, InstallOptions r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return "";
    }

    @Override // com.bytedance.bdinstall.ISstInfoProvider
    public String[] getSimSerialNumbers(Context r1, InstallOptions r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return new String[0];
    }

    @Override // com.bytedance.bdinstall.ISstInfoProvider
    public String reflectGetDeviceIdWithSlotIndex(Context r1, int r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return "";
    }
}
