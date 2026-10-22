package pia;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new c());
    }

    public static Keva i() {
        return (Keva) a.getValue();
    }

    public static Set e() {
        Set r0 = i().getStringSet("voice_print_enrolled_uids", SetsKt.emptySet());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return SetsKt.emptySet();
    }

    public static Set f() {
        Set r0 = i().getStringSet("voice_print_pending_cloud_op_uids", SetsKt.emptySet());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return SetsKt.emptySet();
    }

    public static Set h() {
        Set r0 = i().getStringSet("voice_print_pending_trainable_uids", SetsKt.emptySet());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return SetsKt.emptySet();
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        Set r0 = e();
        if (r0.contains(r4) == false) goto L8;
        return;
    L8:
        LinkedHashSet r1 = new LinkedHashSet(r0);
        r1.add(r4);
        i().storeStringSet("voice_print_enrolled_uids", r1);
        FLogger.a.i("VoiceEnrollUidStore", "addEnrolledUid uid=" + j(r4) + " size=" + r1.size());
    }

    public static void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        Set r0 = f();
        if (r0.contains(r4) == false) goto L8;
        return;
    L8:
        LinkedHashSet r1 = new LinkedHashSet(r0);
        r1.add(r4);
        i().storeStringSet("voice_print_pending_cloud_op_uids", r1);
        FLogger.a.i("VoiceEnrollUidStore", "addPendingCloudOpUid uid=" + j(r4) + " size=" + r1.size());
    }

    public static String c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        Intrinsics.checkNotNullParameter("none", "defValue");
        if (StringsKt.isBlank(r4) == false) goto L6;
        return "none";
    L6:
        return i().getString("default_voice_print_cloud_actual_op_" + r4, "none");
    }

    public static String d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        Intrinsics.checkNotNullParameter("none", "defValue");
        if (StringsKt.isBlank(r4) == false) goto L6;
        return "none";
    L6:
        return i().getString("default_voice_print_cloud_desired_op_" + r4, "none");
    }

    public static Boolean g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        if (StringsKt.isBlank(r3) == false) goto L5;
        return null;
    L5:
        String r4 = "default_voice_print_trainable_pending_" + r3;
        if (i().contains(r4) == true) goto L9;
        return null;
    L9:
        return Boolean.valueOf(i().getBoolean(r4, false));
    }

    public static String j(String r2) {
        if (StringsKt.isBlank(r2) == false) goto L7;
        return "";
    L7:
        return "****" + StringsKt.takeLast(r2, 4);
    }

    public static void k(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        Set r0 = e();
        if (r0.contains(r4) == true) goto L8;
        return;
    L8:
        LinkedHashSet r1 = new LinkedHashSet(r0);
        r1.remove(r4);
        i().storeStringSet("voice_print_enrolled_uids", r1);
        FLogger.a.i("VoiceEnrollUidStore", "removeEnrolledUid uid=" + j(r4) + " size=" + r1.size());
    }

    public static void l(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        Set r0 = f();
        if (r0.contains(r4) == true) goto L8;
        return;
    L8:
        LinkedHashSet r1 = new LinkedHashSet(r0);
        r1.remove(r4);
        i().storeStringSet("voice_print_pending_cloud_op_uids", r1);
        FLogger.a.i("VoiceEnrollUidStore", "removePendingCloudOpUid uid=" + j(r4) + " size=" + r1.size());
    }

    public static void m(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uid");
        if (StringsKt.isBlank(r5) == false) goto L5;
        return;
    L5:
        i().erase("default_voice_print_trainable_pending_" + r5);
        if (StringsKt.isBlank(r5) == true) goto L12;
        Set r0 = h();
        if (r0.contains(r5) == false) goto L12;
        LinkedHashSet r2 = new LinkedHashSet(r0);
        r2.remove(r5);
        i().storeStringSet("voice_print_pending_trainable_uids", r2);
        FLogger.a.i("VoiceEnrollUidStore", "removePendingVoicePrintTrainableUid uid=" + j(r5) + " size=" + r2.size());
    L12:
        FLogger.a.i("VoiceEnrollUidStore", "removePendingVoicePrintTrainable uid=" + j(r5));
    }

    public static void q(String r3) {
        Intrinsics.checkNotNullParameter(r3, "did");
        if (StringsKt.isBlank(r3) == false) goto L5;
        return;
    L5:
        String r2 = "";
        String r0 = i().getString("voice_print_owner_did", "");
        if (r0 == null) goto L10;
        r2 = r0;
    L10:
        if (Intrinsics.areEqual(r2, r3) == false) goto L12;
        return;
    L12:
        i().storeString("voice_print_owner_did", r3);
        FLogger.a.i("VoiceEnrollUidStore", "setVoicePrintOwnerDid didLen=" + r3.length());
    }

    public static void n(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        if (StringsKt.isBlank(r3) == false) goto L5;
        return;
    L5:
        i().storeBoolean("breath_wakeup_enabled_" + r3, r4);
        FLogger.a.i("VoiceEnrollUidStore", "setBreathWakeupEnabled uid=" + j(r3) + " enabled=" + r4);
    }

    public static void o(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "value");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return;
    L5:
        i().storeString("default_voice_print_cloud_actual_op_".concat(r2), r3);
        if (Intrinsics.areEqual(r3, d(r2)) == false) goto L9;
        l(r2);
        return;
    }

    public static void p(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "value");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return;
    L5:
        i().storeString("default_voice_print_cloud_desired_op_".concat(r2), r3);
        int r0 = r3.hashCode();
        if (r0 == (-1335458389)) goto L20;
        if (r0 == (-838595071)) goto L17;
        if (r0 == 3387192) goto L13;
        return;
    L13:
        if (r3.equals("none") == false) goto L26;
        l(r2);
        return;
    L26:
        return;
    L17:
        if (r3.equals("upload") == false) goto L27;
    L21:
        b(r2);
        return;
    L27:
        return;
    L20:
        if (r3.equals("delete") == true) goto L21;
    }

    public static void r(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        if (StringsKt.isBlank(r3) == false) goto L5;
        return;
    L5:
        i().storeBoolean("voice_wakeup_enabled_" + r3, r4);
        FLogger.a.i("VoiceEnrollUidStore", "setVoiceWakeupEnabled uid=" + j(r3) + " enabled=" + r4);
    }
}
