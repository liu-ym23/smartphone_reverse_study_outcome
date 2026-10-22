package com.obric.memorydata.memory.ui.settings.contextawareness;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.settingsharness.p;
import com.obric.memorydata.ui.settingsharness.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ*\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessMainPageContract;", "", "<init>", "()V", "ROW_SCREEN_CONTENT", "", "ROW_AMBIENT_VOICE", "ROW_SYSTEM_APP_DATA", "ROW_SMART_GLASSES", "ROW_MOTION_STATE", "ROW_LOCATION", "ROW_NOTIFICATION_CONTENT", "ROW_DEVICE_STATE", "ROW_CELLULAR_UPLOAD", "ROW_ENHANCED_TIMELINESS", "ROW_BLOCK_RULES", "ROW_RECORDER_AMBIENT_VOICE_COLLECTION_DEBUG", "ACTION_OPEN_SCREEN_CONTENT", "ACTION_OPEN_AMBIENT_VOICE", "ACTION_OPEN_SYSTEM_APP_DATA", "ACTION_OPEN_SMART_GLASSES", "ACTION_OPEN_BLOCK_RULES", "bindingSpec", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageBindingSpec;", "getBindingSpec", "()Lcom/obric/memorydata/ui/settingsharness/SettingsPageBindingSpec;", "pageState", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageState;", "snapshot", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsSnapshot;", NotificationCompat.CATEGORY_NAVIGATION, "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec$Navigation;", OaidModel.KEY_ID, "viewId", "", "actionKey", "bindsDetail", "", "switch", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec$Switch;", "smartGlassesState", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowState;", "globalSourceFor", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessGlobalSource;", "rowId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f11450a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.memorydata.ui.settingsharness.g f11451b = null;

    static {
        d r7 = new d();
        f11450a = r7;
        f11451b = new com.obric.memorydata.ui.settingsharness.g(CollectionsKt.listOf(new p[]{new p("awareness_sources", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.source_section_title, OaidModel.KEY_ID, "source_section_title")), null, CollectionsKt.listOf(new com.obric.memorydata.ui.settingsharness.n[]{a(r7, "screen_content", ZeusTransformUtils.mapRes(R.id.screen_content, OaidModel.KEY_ID, "screen_content"), "open_screen_content", false, 8, null), a(r7, "ambient_voice", ZeusTransformUtils.mapRes(R.id.ambient_voice, OaidModel.KEY_ID, "ambient_voice"), "open_ambient_voice", false, 8, null), r7.a("system_app_data", ZeusTransformUtils.mapRes(R.id.system_app_data, OaidModel.KEY_ID, "system_app_data"), "open_system_app_data", false), a(r7, "smart_glasses", ZeusTransformUtils.mapRes(R.id.smart_glasses, OaidModel.KEY_ID, "smart_glasses"), "open_smart_glasses", false, 8, null), r7.a("motion_state", ZeusTransformUtils.mapRes(R.id.motion_state, OaidModel.KEY_ID, "motion_state")), r7.a("location", ZeusTransformUtils.mapRes(R.id.location, OaidModel.KEY_ID, "location")), r7.a("notification_content", ZeusTransformUtils.mapRes(R.id.notification_content, OaidModel.KEY_ID, "notification_content")), r7.a("device_state", ZeusTransformUtils.mapRes(R.id.device_state, OaidModel.KEY_ID, "device_state"))}), 4, null), new p("data_management", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.data_management_section_title, OaidModel.KEY_ID, "data_management_section_title")), null, CollectionsKt.listOf(new com.obric.memorydata.ui.settingsharness.n[]{r7.a("cellular_upload", ZeusTransformUtils.mapRes(R.id.cellular_upload, OaidModel.KEY_ID, "cellular_upload")), r7.a("enhanced_timeliness", ZeusTransformUtils.mapRes(R.id.enhanced_timeliness, OaidModel.KEY_ID, "enhanced_timeliness")), new com.obric.memorydata.ui.settingsharness.n.a("block_rules", ZeusTransformUtils.mapRes(R.id.block_rules, OaidModel.KEY_ID, "block_rules"), "open_block_rules", false, 8, null)}), 4, null), new p("debug", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.debug_section_title, OaidModel.KEY_ID, "debug_section_title")), null, CollectionsKt.listOf(r7.a("recorder_ambient_voice_collection_debug", ZeusTransformUtils.mapRes(R.id.recorder_ambient_voice_collection_debug, OaidModel.KEY_ID, "recorder_ambient_voice_collection_debug"))), 4, null)}));
    }

    private d() {
    }

    static /* synthetic */ com.obric.memorydata.ui.settingsharness.n.a a(d r0, String r1, int r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = true;
    L6:
        return r0.a(r1, r2, r3, r4);
    }

    private final com.obric.memorydata.ui.settingsharness.n.a a(String r1, int r2, String r3, boolean r4) {
        return new com.obric.memorydata.ui.settingsharness.n.a(r1, r2, r3, r4);
    }

    private final com.obric.memorydata.ui.settingsharness.n.c a(String r1, int r2) {
        return new com.obric.memorydata.ui.settingsharness.n.c(r1, r2);
    }

    private final com.obric.memorydata.ui.settingsharness.o b(i r9) {
        boolean r1 = r9.e();
        if (r9.q() == true) goto L7;
        int r10 = R.string.context_awareness_glasses_not_connected;
        String r2 = "context_awareness_glasses_not_connected";
    L11:
        return new com.obric.memorydata.ui.settingsharness.o(r1, false, false, null, (q) ZeusTransformUtils.preCheckCast(new q.b(ZeusTransformUtils.mapRes(r10, TypedValues.Custom.S_STRING, r2)), q.class, "com.obric.memorydata.plugin"), 14, null);
    L7:
        if (r9.r() == false) goto L9;
        r10 = R.string.context_awareness_enabled;
        r2 = "context_awareness_enabled";
        goto L11
    L9:
        r10 = R.string.context_awareness_disabled;
        r2 = "context_awareness_disabled";
        goto L11
    }

    public final ContextAwarenessGlobalSource a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "rowId");
        switch(r3.hashCode()) {
            case -983775544: goto L15;
            case -585388696: goto L12;
            case 1149978917: goto L9;
            case 1901043637: goto L6;
            default: goto L19;
        };
    L6:
        if (r3.equals("location") == false) goto L19;
        return ContextAwarenessGlobalSource.LOCATION;
    L9:
        if (r3.equals("notification_content") == false) goto L19;
        return ContextAwarenessGlobalSource.NOTIFICATION_CONTENT;
    L12:
        if (r3.equals("device_state") == false) goto L19;
        return ContextAwarenessGlobalSource.DEVICE_STATE;
    L15:
        if (r3.equals("motion_state") == false) goto L19;
        return ContextAwarenessGlobalSource.MOTION_STATE;
    L19:
        throw new IllegalStateException(("Unsupported Context Awareness global source row: " + r3).toString());
    }

    public final com.obric.memorydata.ui.settingsharness.g a() {
        return f11451b;
    }

    public final com.obric.memorydata.ui.settingsharness.i a(i r14) {
        Intrinsics.checkNotNullParameter(r14, "snapshot");
        Pair[] r1 = new Pair[12];
        r1[0] = TuplesKt.to("screen_content", com.obric.memorydata.ui.settingsharness.o.a(e.a(r14.b()), r14.a(), r14.a(), false, null, null, 28, null));
        r1[1] = TuplesKt.to("ambient_voice", com.obric.memorydata.ui.settingsharness.o.a(e.a(r14.d().a()), r14.c(), r14.c(), false, null, null, 28, null));
        r1[2] = TuplesKt.to("system_app_data", new com.obric.memorydata.ui.settingsharness.o(false, false, false, null, null, 31, null));
        r1[3] = TuplesKt.to("smart_glasses", b(r14));
        r1[4] = TuplesKt.to("motion_state", new com.obric.memorydata.ui.settingsharness.o(false, false, false, Boolean.valueOf(r14.g()), null, 23, null));
        r1[5] = TuplesKt.to("location", new com.obric.memorydata.ui.settingsharness.o(false, false, false, Boolean.valueOf(r14.h()), null, 23, null));
        r1[6] = TuplesKt.to("notification_content", new com.obric.memorydata.ui.settingsharness.o(false, false, false, Boolean.valueOf(r14.i()), null, 23, null));
        r1[7] = TuplesKt.to("device_state", new com.obric.memorydata.ui.settingsharness.o(false, false, false, Boolean.valueOf(r14.j()), null, 23, null));
        r1[8] = TuplesKt.to("cellular_upload", new com.obric.memorydata.ui.settingsharness.o(false, false, false, Boolean.valueOf(r14.k()), null, 23, null));
        if (r14.l() == true) goto L5;
    L7:
        boolean r6 = false;
    L9:
        if (r14.l() == true) goto L11;
    L13:
        boolean r7 = false;
    L14:
        r1[9] = TuplesKt.to("enhanced_timeliness", new com.obric.memorydata.ui.settingsharness.o(r6, r7, false, Boolean.valueOf(r14.n()), null, 20, null));
        r1[10] = TuplesKt.to("block_rules", new com.obric.memorydata.ui.settingsharness.o(false, false, false, null, null, 31, null));
        r1[11] = TuplesKt.to("recorder_ambient_voice_collection_debug", new com.obric.memorydata.ui.settingsharness.o(r14.o(), false, false, Boolean.valueOf(r14.p()), null, 22, null));
        return new com.obric.memorydata.ui.settingsharness.i(MapsKt.mapOf(r1));
    L11:
        if (r14.m() == false) goto L13;
        r7 = true;
        goto L14
    L5:
        if (r14.m() == false) goto L7;
        r6 = true;
        goto L9
    }
}
