package com.larus.chat.gallery.impl.preview.input;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.api.PreviewSelectionLimit;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.provider.o0;
import com.larus.chat.gallery.impl.preview.provider.p0;
import com.larus.gallery.api.GalleryType;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PreviewInputCallback implements com.larus.chat.gallery.providers.input.b {
    public final e0 a;
    public final com.larus.gallery.api.w b;
    public final Function0<xy8.d> c;
    public final Function0<FragmentActivity> d;
    public final PreviewCameraParamProvider e;
    public final com.larus.chat.gallery.api.q f;
    public final Function0<Boolean> g;
    public final Function0<Unit> h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;

        static {
            int[] r0 = new int[SourceType.values().length];
            r0[SourceType.USER_SEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[SourceType.BOT_RESP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L57:
            r0[SourceType.CREATION_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L43:
            r0[SourceType.ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L45:
            r0[SourceType.ATTACHMENT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L35:
            r0[SourceType.CAMERA_RESULT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L47:
            r0[SourceType.CLOUD_DRIVE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L49:
            r0[SourceType.CREATION_RECORD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L12:
            a = r0;
            int[] r1 = new int[SuggestedActionScene.values().length];
            r1[SuggestedActionScene.AttachmentAreaSingleImg.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L37:
            r1[SuggestedActionScene.AttachmentAreaMultiImg.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L15:
            b = r1;
            int[] r2 = new int[PreviewSelectionLimit.MediaScope.values().length];
            r2[PreviewSelectionLimit.MediaScope.IMAGE_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L55:
            r2[PreviewSelectionLimit.MediaScope.IMAGE_AND_VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L18:
            c = r2;
            int[] r3 = new int[GalleryType.values().length];
            r3[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L20:
            d = r3;
        }
    }

    static {
    }

    @Override // com.larus.chat.gallery.providers.input.b
    public final boolean d() {
        return true;
    }

    @Override // com.larus.chat.gallery.providers.input.b
    public final void c() {
        FragmentActivity r0 = (FragmentActivity) this.d.invoke();
        if (r0 != null) goto L6;
        FLogger.a.e("PreviewInputCallback", "onCameraEntranceClick: activity is null, ignore");
        return;
    L6:
        xy8.d r2 = (xy8.d) this.c.invoke();
        if (r2 != null) goto L10;
        FLogger.a.e("PreviewInputCallback", "onCameraEntranceClick: currentData is null, ignore");
        return;
    L10:
        xy8.d r3 = (xy8.d) this.c.invoke();
        boolean r4 = true;
        if (r3 == null) goto L57;
        xy8.e r7 = r3.m;
        if (r7 == null) goto L17;
        String r8 = r7.e;
        if (r8 == null) goto L17;
    L20:
        if (r7 == null) goto L23;
        String r9 = r7.c;
        if (r9 == null) goto L23;
    L28:
        if (r3.a != SourceType.USER_SEND) goto L30;
        String r10 = "user";
    L32:
        if (b.d[r3.e.ordinal()] != 1) goto L34;
        String r11 = "video_detail";
    L35:
        JSONObject r12 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r5 = r3.f.entrySet().iterator();
    L37:
        if (r5.hasNext() == false) goto L39;
        Map.Entry<String, Object> r13 = r5.next();
        r12.put(r13.getKey(), r13.getValue());
        goto L37
    L39:
        if (r8 != null) goto L41;
    L44:
        boolean r6 = true;
    L45:
        if (r6 == true) goto L47;
        r12.put("creation_task_id", r8);
    L47:
        if (r9 != null) goto L49;
    L52:
        boolean r14 = true;
    L53:
        if (r14 == true) goto L55;
        r12.put(MusicAppletPage.KEY_MESSAGE_ID, r9);
    L55:
        r12.put("user_type", r10);
        r12.put("current_page", r11);
        r12.put("camera_type", "general");
        com.larus.platform.service.o.a.reportEvent("click_camera", r12);
        goto L57
    L49:
        if (r9.length() == 0) goto L52;
        r14 = false;
        goto L53
    L41:
        if (r8.length() == 0) goto L44;
        r6 = false;
        goto L45
    L34:
        r11 = "picture_detail";
        goto L35
    L30:
        r10 = "bot";
    L23:
        xy8.f r15 = r3.l;
        if (r15 == null) goto L26;
        r9 = r15.a;
        goto L28
    L26:
        r9 = null;
    L17:
        if (r7 == null) goto L19;
        r8 = r7.a;
        goto L20
    L19:
        r8 = null;
    L57:
        if (uy8.b.b("album") == false) goto L76;
        com.larus.chat.gallery.api.q r16 = this.f;
        if (r16 == null) goto L72;
        PreviewSelectionLimit r17 = r16.r(PreviewMediaType.IMAGE);
        if (r17 == null) goto L72;
        int r18 = b.c[r17.b.ordinal()];
        if (r18 != 1) goto L66;
        int r19 = 2131907895;
    L71:
        t19.s r20 = t19.s.a;
        String r21 = r0.getString(r19, new Object[]{String.valueOf(r17.a)});
        r20.getClass();
        t19.s.t(r0, r21);
        boolean r22 = false;
    L73:
        if (r22 == true) goto L76;
        return;
    L66:
        if (r18 != 2) goto L69;
        r19 = 2131910955;
        goto L71
    L69:
        throw new NoWhenBranchMatchedException();
    L72:
        r22 = true;
    L76:
        if (((Boolean) this.g.invoke()).booleanValue() == true) goto L79;
        FLogger.a.e("PreviewInputCallback", "onCameraEntranceClick: pending result unavailable");
        return;
    L79:
        com.larus.chat.gallery.impl.preview.p r1 = this.e.d;
        if ((r1 instanceof com.larus.chat.gallery.impl.preview.p.a) == false) goto L82;
        com.larus.chat.gallery.impl.preview.p.a r23 = (com.larus.chat.gallery.impl.preview.p.a) r1;
    L83:
        if (r23 == null) goto L89;
        q0 r24 = r23.e;
        if (r24 == null) goto L89;
        q0.a r25 = r24.getProvider();
        if (r25 == null) goto L89;
        zb8.e r26 = r25.P8();
    L90:
        if (r26 != null) goto L93;
        r4 = false;
    L93:
        if (r4 == true) goto L95;
        this.a.c(false);
    L95:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new PreviewInputCallback$onCameraEntranceClick$1(this, r0, r2, null), 3, null);
        return;
    L89:
        r26 = null;
        goto L90
    L82:
        r23 = null;
        goto L83
    }

    @Override // com.larus.chat.gallery.providers.input.b
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        PreviewCameraParamProvider r1 = this.e;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        r1.n = r3;
        com.larus.chat.gallery.api.q r0 = this.f;
        if (r0 == null) goto L6;
        r0.s(r3);
        return;
    }

    @Override // com.larus.chat.gallery.providers.input.b
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        f(r2, null);
    }

    @Override // com.larus.chat.gallery.providers.input.b
    public final void e(SuggestedAction r25, SuggestedActionScene r26) {
        Intrinsics.checkNotNullParameter(r25, "action");
        Intrinsics.checkNotNullParameter(r26, "scene");
        if (this.a.d() == false) goto L5;
        return;
    L5:
        xy8.d r2 = (xy8.d) this.c.invoke();
        if (r2 != null) goto L9;
        FLogger.a.e("PreviewInputCallback", "onSuggestedActionClick: currentData is null, ignore");
        return;
    L9:
        Map r11 = r25.getEventExtra();
        if (r11 == null) goto L13;
        Map r12 = MapsKt.toMutableMap(r11);
        if (r12 == null) goto L13;
    L14:
        int r13 = b.b[r26.ordinal()];
        if (r13 != 1) goto L17;
    L19:
        r12.put("sug_scene", "attachment_suggest");
    L20:
        Unit r10 = Unit.INSTANCE;
        String r18 = null;
        if ((!r12.isEmpty()) == false) goto L23;
        Map r14 = r12;
    L24:
        SuggestedAction r3 = SuggestedAction.copy$default(r25, null, 0, 0, null, false, null, null, null, null, r14, null, null, 3583, null);
        e0 r4 = this.a;
        Map r5 = r3.getEventExtra();
        if (r5 == null) goto L28;
        r18 = (String) r5.get("sug_scene");
    L28:
        if (r4.b(r3, r2, r18) == false) goto L32;
        com.larus.gallery.api.w r1 = this.b;
        if (r1 == null) goto L34;
        r1.Rf(com.larus.gallery.api.p.c.a);
        return;
    L34:
        return;
    L32:
        FLogger.a.e("PreviewInputCallback", "onSuggestedActionClick: handoff failed, scene=" + r26);
        return;
    L23:
        r14 = null;
        goto L24
    L17:
        if (r13 == 2) goto L19;
    L13:
        r12 = new LinkedHashMap();
        goto L14
    }

    public final void f(String r6, zy8.s r7) {
        Intrinsics.checkNotNullParameter(r6, ShareType.TEXT);
        if (this.a.d() == false) goto L5;
        return;
    L5:
        xy8.d r0 = (xy8.d) this.c.invoke();
        if (r0 != null) goto L9;
        FLogger.a.e("PreviewInputCallback", "onSendText: currentData is null, ignore");
        return;
    L9:
        FLogger.a.i("PreviewInputCallback", "onSendText, sourceType=" + r0.a);
        switch(b.a[r0.a.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L13;
            default: goto L12;
        };
    L13:
        boolean r8 = this.a.h(r6, r0);
    L15:
        if (r8 == false) goto L20;
        com.larus.gallery.api.w r9 = this.b;
        if (r9 == null) goto L21;
        r9.Rf(com.larus.gallery.api.p.c.a);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        r8 = this.a.e(r6, r0, r7);
        goto L15
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public PreviewInputCallback(e0 r2, com.larus.gallery.api.w r3, o0 r4, p0 r5, PreviewCameraParamProvider r6, com.larus.chat.gallery.api.q r7, com.larus.chat.gallery.impl.preview.provider.q0 r8, Function0 r9) {
        Intrinsics.checkNotNullParameter(r2, "sendStrategy");
        Intrinsics.checkNotNullParameter(r4, "currentDataProvider");
        Intrinsics.checkNotNullParameter(r5, "activityProvider");
        Intrinsics.checkNotNullParameter(r6, "paramProvider");
        Intrinsics.checkNotNullParameter(r8, "onBeforeCameraLaunch");
        Intrinsics.checkNotNullParameter(r9, "onCameraLaunchFailed");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
