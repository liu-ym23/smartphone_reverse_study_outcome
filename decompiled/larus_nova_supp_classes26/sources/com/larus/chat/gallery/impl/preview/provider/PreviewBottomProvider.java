package com.larus.chat.gallery.impl.preview.provider;

import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.api.params.VideoParam;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.impl.preview.data.LocalMediaType;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.input.ChildResultMode;
import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.chat.gallery.impl.preview.input.PreviewInputCallback;
import com.larus.chat.gallery.providers.input.GalleryInputFragment;
import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.GalleryType;
import com.larus.platform.AlbumHelper;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.model.album.AlbumInputState;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.preview.AttachmentEditType;
import com.larus.platform.model.preview.AttachmentMediaType;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.MediaEntry;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PreviewBottomProvider extends com.larus.gallery.api.t<xy8.d> implements com.larus.chat.gallery.impl.preview.input.m {
    public static final /* synthetic */ int x = 0;
    public final com.larus.chat.gallery.impl.preview.input.e0 f;
    public final Long g;
    public final PreviewCameraParamProvider h;
    public final com.larus.chat.gallery.impl.preview.c i;
    public final com.larus.chat.gallery.impl.preview.input.d0 j;
    public final r k;
    public final boolean l;
    public final com.larus.chat.gallery.api.z m;
    public final boolean n;
    public final AlbumHelper o;
    public boolean p;
    public boolean q;
    public Boolean r;
    public boolean s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements zy8.u {
        public final /* synthetic */ PreviewBottomProvider a;

        public c(PreviewBottomProvider r1) {
            this.a = r1;
        }

        @Override // zy8.u
        public final boolean b(String r4, zy8.s r5) {
            Intrinsics.checkNotNullParameter(r4, ShareType.TEXT);
            PreviewBottomProvider r0 = this.a;
            xy8.d r1 = (xy8.d) ((com.larus.gallery.api.t) r0).d;
            if (r1 == null) goto L5;
            GalleryType r2 = r1.e;
        L7:
            if (r2 == GalleryType.Image) goto L10;
            FLogger.a.w("PreviewBottomProvider", "sendTextWithCurrentImage skipped: current is not image");
            return false;
        L10:
            r0.C().f(r4, r5);
            return true;
        L5:
            r2 = null;
            goto L7
        }
    }

    static {
    }

    public final boolean m() {
        return false;
    }

    public final void B() {
        if (this.q == true) goto L5;
        return;
    L5:
        t19.s.a.a();
        this.q = false;
    }

    public final PreviewInputCallback C() {
        return (PreviewInputCallback) this.t.getValue();
    }

    public final GalleryInputFragment D() {
        return (GalleryInputFragment) this.u.getValue();
    }

    public final com.larus.chat.gallery.api.q E() {
        return this.j.getSession();
    }

    public final void I() {
        xy8.d r1 = (xy8.d) ((com.larus.gallery.api.t) this).d;
        AlbumInputState r2 = null;
        if (r1 == null) goto L76;
        xy8.e r5 = r1.m;
        if (r5 == null) goto L9;
        String r6 = r5.e;
        if (r6 == null) goto L9;
    L12:
        if (r5 == null) goto L15;
        String r7 = r5.c;
        if (r7 == null) goto L15;
    L20:
        if (r1.a != SourceType.USER_SEND) goto L22;
        String r8 = "user";
    L24:
        if (b.a[r1.e.ordinal()] != 2) goto L26;
        String r9 = "video_detail";
    L27:
        String r10 = (String) this.h.b.invoke();
        wc9.e r11 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r11 == null) goto L30;
        String r12 = r11.a;
    L31:
        if (r10 != null) goto L33;
    L36:
        boolean r13 = true;
    L37:
        if (r13 == true) goto L48;
        if (r12 != null) goto L40;
    L43:
        boolean r14 = true;
    L44:
        if (r14 == true) goto L48;
        if (Intrinsics.areEqual(r10, r12) == false) goto L48;
        String r15 = "default";
    L49:
        Object r16 = r1.f.get("enter_method");
        if ((r16 instanceof String) == false) goto L52;
        String r17 = (String) r16;
    L53:
        if (r17 != null) goto L55;
        r17 = "";
    L55:
        JSONObject r18 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r3 = r1.f.entrySet().iterator();
    L57:
        if (r3.hasNext() == false) goto L59;
        Map.Entry<String, Object> r19 = r3.next();
        r18.put(r19.getKey(), r19.getValue());
        goto L57
    L59:
        if (r6 != null) goto L61;
    L64:
        boolean r4 = true;
    L65:
        if (r4 == true) goto L67;
        r18.put("creation_task_id", r6);
    L67:
        if (r7 != null) goto L69;
    L72:
        boolean r20 = true;
    L73:
        if (r20 == true) goto L75;
        r18.put(MusicAppletPage.KEY_MESSAGE_ID, r7);
    L75:
        r18.put("click_from", "click_input_plus_icon");
        r18.put("current_page", r9);
        r18.put("chat_type", r15);
        r18.put("enter_method", r17);
        r18.put("user_type", r8);
        com.larus.platform.service.o.a.reportEvent("click_upload_entrance", r18);
        goto L76
    L69:
        if (r7.length() == 0) goto L72;
        r20 = false;
        goto L73
    L61:
        if (r6.length() == 0) goto L64;
        r4 = false;
        goto L65
    L52:
        r17 = null;
        goto L53
    L40:
        if (r12.length() == 0) goto L43;
        r14 = false;
    L48:
        r15 = "default_new";
        goto L49
    L33:
        if (r10.length() == 0) goto L36;
        r13 = false;
        goto L37
    L30:
        r12 = null;
        goto L31
    L26:
        r9 = "picture_detail";
        goto L27
    L22:
        r8 = "bot";
    L15:
        xy8.f r21 = r1.l;
        if (r21 == null) goto L18;
        r7 = r21.a;
        goto L20
    L18:
        r7 = null;
    L9:
        if (r5 == null) goto L11;
        r6 = r5.a;
        goto L12
    L11:
        r6 = null;
    L76:
        com.larus.chat.gallery.api.q r22 = E();
        if (r22 == null) goto L88;
        List<AttachmentSnapshot> r23 = r22.Qa();
        if (r23 == null) goto L88;
        HashSet r24 = new HashSet();
        ArrayList r25 = new ArrayList();
        Iterator<T> r26 = r23.iterator();
    L82:
        if (r26.hasNext() == false) goto L86;
        Object r27 = r26.next();
        if (r24.add(((AttachmentSnapshot) r27).getStableId()) == false) goto L82;
        r25.add(r27);
        goto L82
    L86:
        int r28 = r25.size();
    L97:
        int r29 = RangesKt.coerceAtLeast(20 - r28, 0);
        if (r29 != 0) goto L102;
        t19.s r30 = t19.s.a;
        AppHost.Companion r31 = AppHost.a;
        Application r32 = r31.getApplication();
        String r33 = r31.getApplication().getString(2131910955, new Object[]{"20"});
        r30.getClass();
        t19.s.t(r32, r33);
        return;
    L102:
        if (this.i.g == false) goto L109;
        xy8.d r34 = (xy8.d) ((com.larus.gallery.api.t) this).d;
        if (r34 == null) goto L109;
        PreviewCameraParamProvider r35 = this.h;
        com.larus.chat.gallery.api.q r36 = E();
        r35.getClass();
        Intrinsics.checkNotNullParameter(r34, "data");
        if (r35.s(r36) == false) goto L109;
        int r37 = com.larus.chat.gallery.impl.preview.input.y.a;
        InputDraftSnapshot r38 = com.larus.chat.gallery.impl.preview.input.y.b(r36, r35.n, r34, true, SetsKt.emptySet());
        String r110 = r35.l(r38);
        Intrinsics.checkNotNullParameter(r38, "snapshot");
        Intrinsics.checkNotNullParameter(r110, "snapshotId");
        r2 = new AlbumInputState(r38.getText(), r38.getAttachments(), r38.getSourceNodeId(), r110, null, 16, null);
    L109:
        AlbumSettingConfig.a r39 = new AlbumSettingConfig.a();
        r39.o = Boolean.valueOf(this.h.h);
        r39.c = true;
        r39.d = r29;
        r39.f = "preview_gallery_plus";
        r39.n = true;
        r39.c(MediaEntry.PREVIEW_PLUS);
        Boolean r40 = this.i.f;
        if (r40 == null) goto L112;
        r39.i = r40.booleanValue();
    L112:
        Boolean r41 = this.i.h;
        if (r41 == null) goto L116;
        r39.m = r41.booleanValue();
    L116:
        if (this.i.g == false) goto L119;
        if (r2 == null) goto L119;
        r39.k = true;
        r39.b(r2);
        r39.q = true;
    L119:
        AlbumSettingConfig r42 = r39.a();
        J();
        AlbumHelper.f(this.o, D(), r42, new z(), new k0(this), (String) this.h.a.invoke(), null, 0, null, "preview_gallery", null, null, null, 3584);
        return;
    L88:
        if (this.i.b == false) goto L96;
        xy8.d r43 = (xy8.d) ((com.larus.gallery.api.t) this).d;
        if (r43 == null) goto L92;
        GalleryType r44 = r43.e;
    L94:
        if (r44 != GalleryType.Image) goto L96;
        r28 = 1;
        goto L97
    L92:
        r44 = null;
    L96:
        r28 = 0;
        goto L97
    }

    public final void J() {
        if (this.i.g == false) goto L6;
        G(new b0());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.larus.chat.gallery.impl.preview.provider.w0] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.larus.chat.gallery.impl.preview.provider.a0] */
    /* JADX WARN: Type inference failed for: r1v20, types: [com.larus.chat.gallery.impl.preview.provider.y0] */
    /* JADX WARN: Type inference failed for: r1v22, types: [com.larus.chat.gallery.impl.preview.provider.x0] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.chat.gallery.impl.preview.input.o, ex8.b] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void t() {
        com.larus.gallery.api.w r0 = ((com.larus.gallery.api.t) this).e;
        if (r0 == null) goto L5;
        r0.Op(Reflection.getOrCreateKotlinClass(com.larus.chat.gallery.impl.preview.input.m.class), this);
    L5:
        com.larus.gallery.api.w r1 = ((com.larus.gallery.api.t) this).e;
        if (r1 == null) goto L8;
        r1.Op(Reflection.getOrCreateKotlinClass(zy8.u.class), new c(this));
    L8:
        PreviewCameraParamProvider r2 = this.h;
        r2.j = new t0(this);
        if (E() == null) goto L11;
        L(D());
    L11:
        PreviewCameraParamProvider r3 = this.h;
        String r4 = this.j.a();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, ShareType.TEXT);
        r3.n = r4;
        PreviewCameraParamProvider r5 = this.h;
        r5.e.d = new u0(this);
        PreviewCameraParamProvider r6 = this.h;
        r6.k = new v0(this);
        r6.l = new PreviewBottomProvider$onAttach$5(this.j);
        final PreviewCameraParamProvider r7 = this.h;
        r7.getClass();
        IFlowCamera r8 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r8 != null) goto L15;
        FLogger.a.e("PreviewCameraParamProvider", "setupCommandListener: IFlowCamera service not found");
    L18:
        this.j.j(new w0(this));
        com.larus.chat.gallery.api.z r9 = this.m;
        if (r9 == 0) goto L21;
        r9.e(new x0(this));
    L21:
        com.larus.chat.gallery.api.z r10 = this.m;
        if (r10 == null) goto L24;
        r10.g(new PreviewBottomProvider$onAttach$8(C()));
    L24:
        com.larus.chat.gallery.api.z r11 = this.m;
        if (r11 == 0) goto L27;
        r11.f(new y0(this));
    L27:
        com.larus.chat.gallery.api.z r12 = this.m;
        if (r12 == null) goto L30;
        r12.c(new PreviewBottomProvider$onAttach$10(C()));
    L30:
        com.larus.chat.gallery.api.z r13 = this.m;
        if (r13 != null) goto L33;
    L37:
        this.f.a(new a0(this));
        FLogger.a.i("PreviewBottomProvider", "onAttach: registered IPreviewInputCapability & ISendTextWithImageCapability");
        return;
    L33:
        if (this.i.a == false) goto L35;
        PreviewBottomProvider$onAttach$11 r14 = new PreviewBottomProvider$onAttach$11(this);
    L36:
        r13.b(r14);
        goto L37
    L35:
        r14 = null;
        goto L36
    L15:
        if (r7.q != null) goto L18;
        ?? r15 = new com.larus.chat.gallery.impl.preview.input.o(r7);
        r7.p = r8.t();
        r7.q = r15;
        r8.f(r15);
        FLogger.a.i("PreviewCameraParamProvider", "setupCommandListener: done");
        goto L18
    }

    public final void u() {
        B();
        this.f.a(null);
        this.f.c(true);
        PreviewCameraParamProvider r0 = this.h;
        r0.j = null;
        r0.e.d = null;
        PreviewCameraParamProvider r1 = this.h;
        r1.k = null;
        r1.l = null;
        IFlowCamera r2 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        com.larus.chat.gallery.impl.preview.input.o r3 = r1.q;
        ex8.b r4 = r1.p;
        if (r3 == null) goto L9;
        if (r2 == null) goto L6;
        ex8.b r5 = r2.t();
    L7:
        if (r5 != r3) goto L9;
        r2.f(r4);
        goto L9
    L6:
        r5 = null;
    L9:
        r1.q = null;
        r1.p = null;
        this.h.k();
        com.larus.chat.gallery.impl.preview.p r6 = this.h.d;
        if ((r6 instanceof com.larus.chat.gallery.impl.preview.p.a) == false) goto L12;
        com.larus.chat.gallery.impl.preview.p.a r7 = (com.larus.chat.gallery.impl.preview.p.a) r6;
    L13:
        if (r7 == null) goto L21;
        com.larus.bmhome.chat.api.q0 r8 = r7.e;
        if (r8 == null) goto L21;
        com.larus.bmhome.chat.api.q0.a r9 = r8.getProvider();
        if (r9 == null) goto L21;
        zb8.e r10 = r9.P8();
        if (r10 == null) goto L21;
        r10.MI();
    L21:
        this.j.detach();
        com.larus.chat.gallery.api.z r11 = this.m;
        if (r11 == null) goto L24;
        r11.e(null);
    L24:
        com.larus.chat.gallery.api.z r12 = this.m;
        if (r12 == null) goto L27;
        r12.g(null);
    L27:
        com.larus.chat.gallery.api.z r13 = this.m;
        if (r13 == null) goto L30;
        r13.f(null);
    L30:
        com.larus.chat.gallery.api.z r14 = this.m;
        if (r14 == null) goto L33;
        r14.c(null);
    L33:
        com.larus.chat.gallery.api.z r15 = this.m;
        if (r15 == null) goto L37;
        r15.b(null);
    L37:
        if (this.l == false) goto L43;
        com.larus.chat.gallery.providers.input.a r16 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(D()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r16 == null) goto L41;
        Intrinsics.checkNotNullParameter(r16, "$this$inputAbility");
        r16.g();
        Unit r17 = Unit.INSTANCE;
        return;
    L41:
        FLogger.a.e("PreviewBottomProvider", "[inputAbility] failed, cannot get GalleryInputAbility");
        return;
    L43:
        return;
    L12:
        r7 = null;
        goto L13
    }

    public final boolean A(CameraOutputContext r6) {
        if (this.j.h(r6, (xy8.d) ((com.larus.gallery.api.t) this).d) == true) goto L6;
        return false;
    L6:
        xy8.d r7 = (xy8.d) ((com.larus.gallery.api.t) this).d;
        if (r7 == null) goto L9;
        SourceType r8 = r7.a;
    L10:
        List<com.larus.chat.gallery.api.o> r0 = this.j.l();
        if (r8 != null) goto L13;
    L21:
        com.larus.chat.gallery.api.o r9 = this.j.b();
        if (r9 != null) goto L24;
        return true;
    L24:
        M(r9);
        return true;
    L13:
        if ((!r0.isEmpty()) == false) goto L21;
        com.larus.gallery.api.w r2 = ((com.larus.gallery.api.t) this).e;
        if (r2 == null) goto L21;
        List<com.larus.chat.gallery.api.o> r1 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r4 = r1.iterator();
    L18:
        if (r4.hasNext() == false) goto L20;
        r3.add(com.larus.chat.gallery.impl.preview.datasource.m.a((com.larus.chat.gallery.api.o) r4.next(), r8));
        goto L18
    L20:
        r2.Rf(new com.larus.gallery.api.p.a(r3));
        goto L21
    L9:
        r8 = null;
        goto L10
    }

    public final void F(String r4) {
        xy8.d r0 = (xy8.d) ((com.larus.gallery.api.t) this).d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f.e(r4, r0, null) == false) goto L11;
        com.larus.gallery.api.w r5 = ((com.larus.gallery.api.t) this).e;
        if (r5 == null) goto L12;
        r5.Rf(com.larus.gallery.api.p.c.a);
        return;
    L12:
        return;
    }

    public final void G(Function1<? super com.larus.chat.gallery.providers.input.a, Unit> r3) {
        com.larus.chat.gallery.providers.input.a r0 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(D()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r0 == null) goto L5;
        r3.invoke(r0);
        return;
    L5:
        FLogger.a.e("PreviewBottomProvider", "[inputAbility] failed, cannot get GalleryInputAbility");
    }

    public final void H(xp9.i r18) {
        if (this.p == false) goto L6;
        FLogger.a.i("PreviewBottomProvider", "launchMarkPageWithAlbumResult ignored: mark page is launching");
        return;
    L6:
        FragmentActivity r0 = D().getActivity();
        String r3 = null;
        if ((r0 instanceof FragmentActivity) == false) goto L9;
        FragmentActivity r4 = r0;
    L10:
        if (r4 != null) goto L13;
        FLogger.a.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: activity is null");
        return;
    L13:
        IFlowCamera r5 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r5 != null) goto L17;
        FLogger.a.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: IFlowCamera service not found");
        return;
    L17:
        xy8.d r6 = (xy8.d) ((com.larus.gallery.api.t) this).d;
        boolean r1 = false;
        if (this.i.e == false) goto L34;
        if (r6 == null) goto L21;
        GalleryType r2 = r6.e;
    L23:
        if (r2 != GalleryType.Image) goto L34;
        xy8.b r7 = r6.c;
        if (r7 == null) goto L34;
        String r8 = r7.d;
        if (r8 == null) goto L34;
        if (r8.length() <= 0) goto L31;
        boolean r9 = true;
    L32:
        if (r9 == false) goto L34;
        String r10 = r8;
    L35:
        com.larus.chat.gallery.impl.preview.c r11 = this.i;
        if (r11.b == false) goto L54;
        if (r6 == null) goto L39;
        GalleryType r12 = r6.e;
    L41:
        if (r12 != GalleryType.Image) goto L54;
        xy8.b r13 = r6.c;
        if (r13 == null) goto L46;
        String r14 = r13.a;
        if (r14 == null) goto L46;
    L55:
        if (r14 != null) goto L57;
    L58:
        r1 = true;
    L59:
        if (r1 == true) goto L61;
        this.p = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(D()), null, null, new PreviewBottomProvider$launchMarkPageWithAlbumResult$1(r10, this, r4, r5, r6, r14, r18, null), 3, null);
        return;
    L61:
        y(r4, r5, r6, r14, null, r18);
        return;
    L57:
        if (r14.length() != 0) goto L59;
    L46:
        if (r13 == null) goto L52;
        String r15 = r13.c;
        if (r15 == null) goto L52;
        if (r11.d == false) goto L52;
        r3 = r15;
    L52:
        if (r3 != null) goto L54;
        r14 = r10;
        goto L55
    L39:
        r12 = null;
    L54:
        r14 = r3;
        goto L55
    L31:
        r9 = false;
        goto L32
    L21:
        r2 = null;
    L34:
        r10 = null;
        goto L35
    L9:
        r4 = null;
        goto L10
    }

    public final void K(xy8.d r8) {
        final List r1 = null;
        if (this.i.g == true) goto L5;
    L55:
        final SuggestedActionScene r9 = null;
    L56:
        if (r9 != null) goto L62;
        com.larus.chat.gallery.providers.input.a r10 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(D()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r10 == null) goto L60;
        Intrinsics.checkNotNullParameter(r10, "$this$inputAbility");
        r10.qC();
        Unit r11 = Unit.INSTANCE;
        return;
    L60:
        FLogger.a.e("PreviewBottomProvider", "[inputAbility] failed, cannot get GalleryInputAbility");
        return;
    L62:
        String r0 = (String) this.h.a.invoke();
        if (r0 != null) goto L65;
        r0 = "";
    L65:
        SuggestedActionData r2 = com.larus.bmhome.chat.camera.command.v.a(r0);
        if (r2 != null) goto L68;
        r2 = bc8.e.a.b(r0);
    L68:
        if (r2 == null) goto L72;
        List r3 = r2.get(r9);
        if (r3 == null) goto L72;
        r1 = CollectionsKt.filterNotNull(r3);
    L72:
        if (r1 != null) goto L74;
        r1 = CollectionsKt.emptyList();
    L74:
        G(new r0(r1, r9, this));
        return;
    L5:
        if (this.l == false) goto L55;
        if (r8 == null) goto L55;
        SourceType r4 = r8.a;
        if (r4 == SourceType.ALBUM) goto L14;
        if (r4 != SourceType.ATTACHMENT) goto L55;
    L14:
        if (com.larus.bmhome.chat.camera.command.q.b(this.h.e.e) == false) goto L55;
        if (r8.e != GalleryType.Image) goto L55;
        com.larus.chat.gallery.api.q r12 = E();
        if (r12 == null) goto L22;
        List<AttachmentSnapshot> r13 = r12.Qa();
    L23:
        if (r13 != null) goto L25;
        r13 = CollectionsKt.emptyList();
    L25:
        com.larus.chat.gallery.api.q r5 = E();
        if (r5 == null) goto L28;
        List<AttachmentSnapshot> r6 = r5.Qa();
    L29:
        if (r6 != null) goto L31;
        r6 = CollectionsKt.emptyList();
    L31:
        List<AttachmentSnapshot> r7 = r6;
        int r14 = 0;
        if ((r7 instanceof Collection) == true) goto L34;
    L36:
        Iterator<T> r15 = r7.iterator();
        int r16 = 0;
    L38:
        if (r15.hasNext() == false) goto L47;
        if (((AttachmentSnapshot) r15.next()).getMediaType() != AttachmentMediaType.IMAGE) goto L42;
        boolean r17 = true;
    L43:
        if (r17 == false) goto L38;
        r16 = r16 + 1;
        if (r16 >= 0) goto L38;
        CollectionsKt.throwCountOverflow();
        goto L38
    L42:
        r17 = false;
        goto L43
    L47:
        r14 = r16;
    L48:
        if (r14 == 0) goto L50;
    L52:
        if (r14 <= 1) goto L54;
        r9 = SuggestedActionScene.AttachmentAreaMultiImg;
        goto L56
    L54:
        r9 = SuggestedActionScene.AttachmentAreaSingleImg;
        goto L56
    L50:
        if ((!r13.isEmpty()) == false) goto L52;
    L34:
        if (r7.isEmpty() == false) goto L36;
    L28:
        r6 = null;
        goto L29
    L22:
        r13 = null;
        goto L23
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.chat.gallery.impl.preview.provider.e0, java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.chat.gallery.impl.preview.input.s] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.chat.gallery.impl.preview.provider.f0, java.lang.Object, kotlin.jvm.functions.Function0] */
    public final void L(GalleryInputFragment r6) {
        final IFlowCamera r0 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r0 != null) goto L6;
        FLogger.a.e("PreviewBottomProvider", "registerCameraResult: IFlowCamera service not found");
        return;
    L6:
        final ?? r1 = new e0(this, r0);
        final ?? r2 = new f0(this);
        r0.m(r6, r1, r2);
        PreviewCameraParamProvider r3 = this.h;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "onSuccess");
        Intrinsics.checkNotNullParameter(r2, "onFail");
        com.larus.chat.gallery.impl.preview.p r4 = r3.d;
        if ((r4 instanceof com.larus.chat.gallery.impl.preview.p.a) == false) goto L9;
        com.larus.chat.gallery.impl.preview.p.a r5 = (com.larus.chat.gallery.impl.preview.p.a) r4;
    L10:
        if (r5 == null) goto L18;
        com.larus.bmhome.chat.api.q0 r7 = r5.e;
        if (r7 == null) goto L18;
        com.larus.bmhome.chat.api.q0.a r8 = r7.getProvider();
        if (r8 == null) goto L18;
        zb8.e r9 = r8.P8();
        if (r9 == null) goto L18;
        zb8.e.a.a(r9, new com.larus.chat.gallery.impl.preview.input.r(r1), new com.larus.chat.gallery.impl.preview.input.s(r2), 4);
    L18:
        r0.p(r6, new g0(this));
        return;
    L9:
        r5 = null;
        goto L10
    }

    public final void M(com.larus.chat.gallery.api.o r35) {
        xy8.d r3 = (xy8.d) ((com.larus.gallery.api.t) this).d;
        if (r3 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r3.b, r35.a) == true) goto L8;
        return;
    L8:
        com.larus.chat.gallery.impl.preview.datasource.n r2 = com.larus.chat.gallery.impl.preview.datasource.n.a;
        String r4 = r35.b;
        r2.getClass();
        String r5 = com.larus.chat.gallery.impl.preview.datasource.n.a(r4);
        if (r35.getType() != PreviewMediaType.VIDEO) goto L15;
        String r6 = r35.a;
        String r18 = com.larus.chat.gallery.impl.preview.datasource.n.d(r35.b);
        String r22 = com.larus.chat.gallery.impl.preview.datasource.n.c(r35.b);
        String r7 = com.larus.chat.gallery.impl.preview.datasource.n.a(r35.b);
        if (StringsKt.startsWith(r7, "content://", true) == true) goto L14;
        r7 = null;
    L14:
        xy8.d r1 = xy8.d.a(r3, null, new xy8.g(r6, r18, null, com.larus.chat.gallery.impl.preview.datasource.n.b(r35.d), null, r22, null, null, null, r35.e, r35.f, r35.g / 1000.0d, null, null, r7, 29140), GalleryType.Video, null, null, null, null, null, new xy8.c(LocalMediaType.VIDEO, r5, com.larus.chat.gallery.impl.preview.datasource.n.c(r35.b)), 0, 98275);
    L16:
        com.larus.gallery.api.w r8 = ((com.larus.gallery.api.t) this).e;
        if (r8 != null) goto L19;
        return;
    L19:
        if (E() == null) goto L21;
        boolean r15 = true;
    L22:
        r8.Rf(new com.larus.gallery.api.p.j(r1, r15));
        return;
    L21:
        r15 = false;
        goto L22
    L15:
        r1 = xy8.d.a(r3, new xy8.b(r5, com.larus.chat.gallery.impl.preview.datasource.n.b(r35.d), r5, null, null, false, null, r35.e, r35.f, 248), null, GalleryType.Image, null, null, null, null, null, new xy8.c(LocalMediaType.IMAGE, r5, com.larus.chat.gallery.impl.preview.datasource.n.c(r35.b)), 0, 98275);
        goto L16
    }

    public final void N(boolean r3) {
        if (Intrinsics.areEqual(this.r, Boolean.valueOf(r3)) == false) goto L5;
        return;
    L5:
        this.r = Boolean.valueOf(r3);
        com.larus.gallery.api.w r4 = ((com.larus.gallery.api.t) this).e;
        if (r4 == null) goto L11;
        com.larus.gallery.api.s r5 = r4.AQ(Reflection.getOrCreateKotlinClass(com.larus.gallery.api.s.class));
        if (r5 == null) goto L12;
        r5.c();
        return;
    L12:
        return;
    }

    public final Fragment o(ViewGroup r3) {
        FLogger.a.i("PreviewBottomProvider", "createFragment");
        return (Fragment) this.w.getValue();
    }

    public final Map<String, String> z(CameraOutputContext r7) {
        xy8.d r0 = (xy8.d) ((com.larus.gallery.api.t) this).d;
        if (r0 != null) goto L5;
        return null;
    L5:
        List<OutputParam> r8 = r7.getOutputParamList();
        boolean r3 = false;
        if (r8 == null) goto L25;
        List<OutputParam> r9 = r8;
        if ((r9 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L11;
        OutputParam r4 = (OutputParam) r10.next();
        if (r4 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == false) goto L14;
        boolean r11 = true;
    L23:
        if (r11 != true) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == true) goto L28;
        return null;
    L28:
        LinkedHashMap r13 = new LinkedHashMap();
        if (r0.e != GalleryType.Image) goto L31;
        r13.put("content_source_to_record", "chat_upload");
        r13.put("content_source_entrance_to_record", "chat");
    L31:
        SourceType r6 = r0.a;
        if (r6 != SourceType.CREATION_CARD) goto L34;
    L35:
        xy8.e r14 = r0.m;
        if (r14 == null) goto L39;
        String r15 = r14.c;
        if (r15 == null) goto L39;
    L43:
        if (r14 == null) goto L46;
        String r1 = r14.e;
        if (r1 == null) goto L46;
    L49:
        if (r15 != null) goto L51;
    L54:
        boolean r16 = true;
    L55:
        if (r16 == true) goto L57;
        r13.put("pic_source_message_id", r15);
    L57:
        if (r1 != null) goto L59;
    L60:
        r3 = true;
    L61:
        if (r3 == true) goto L64;
        r13.put("source_creation_task_id", r1);
    L64:
        if ((!r13.isEmpty()) == true) goto L66;
        return null;
    L66:
        return r13;
    L59:
        if (r1.length() != 0) goto L61;
    L51:
        if (r15.length() == 0) goto L54;
        r16 = false;
    L46:
        if (r14 == null) goto L48;
        r1 = r14.a;
        goto L49
    L48:
        r1 = null;
    L39:
        xy8.f r2 = r0.l;
        if (r2 == null) goto L42;
        r15 = r2.a;
        goto L43
    L42:
        r15 = null;
        goto L43
    L34:
        if (r6 != SourceType.CREATION_RECORD) goto L64;
    L18:
        if (r4.isFromAlbum() == true) goto L20;
        r5 = true;
    L11:
        r11 = false;
        goto L23
    L10:
        if (r9.isEmpty() == false) goto L12;
    L25:
        r12 = false;
        goto L26
    }

    public final void w(Object r11, int r12) {
        final xy8.d r13 = (xy8.d) r11;
        Intrinsics.checkNotNullParameter(r13, "data");
        ((com.larus.gallery.api.t) this).d = r13;
        this.k.a(r13.b);
        com.larus.chat.gallery.api.z r0 = this.m;
        if (r0 == null) goto L5;
        r0.d(r13.b);
    L5:
        SourceType r1 = r13.a;
        if (r1 != SourceType.ALBUM) goto L8;
    L15:
        boolean r2 = true;
    L17:
        if (r2 == true) goto L45;
        final com.larus.chat.gallery.impl.preview.provider.c r3 = (com.larus.chat.gallery.impl.preview.provider.c) this.v.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r13, "data");
        if (r13.p != null) goto L21;
        boolean r14 = false;
    L40:
        if (r14 == false) goto L45;
        com.larus.chat.gallery.providers.input.a r15 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(D()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r15 == null) goto L44;
        Intrinsics.checkNotNullParameter(r15, "$this$inputAbility");
        r15.qC();
        Unit r16 = Unit.INSTANCE;
        return;
    L44:
        FLogger.a.e("PreviewBottomProvider", "[inputAbility] failed, cannot get GalleryInputAbility");
        return;
    L21:
        GalleryInputFragment r7 = r3.a;
        com.larus.chat.gallery.impl.preview.toolbar.action.r.a.getClass();
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r13, "data");
        xy8.c r17 = r13.p;
        if (r17 != null) goto L24;
        boolean r18 = false;
    L39:
        r7.ga0(true, r18, new com.larus.chat.gallery.impl.preview.provider.b(r3, r13));
        r3.b.invoke();
        r14 = true;
        goto L40
    L24:
        String r8 = r17.c;
        if (r8 != null) goto L27;
    L31:
        r8 = com.larus.chat.gallery.impl.preview.toolbar.action.r.a(r17.b);
    L32:
        if (r8 != null) goto L34;
    L37:
        boolean r19 = true;
    L38:
        r18 = !r19;
        goto L39
    L34:
        if (StringsKt.isBlank(r8) == true) goto L37;
        r19 = false;
        goto L38
    L27:
        if ((!StringsKt.isBlank(r8)) == true) goto L30;
        r8 = null;
    L30:
        if (r8 != null) goto L32;
    L45:
        GalleryInputFragment r110 = ((com.larus.chat.gallery.impl.preview.provider.c) this.v.getValue()).a;
        int r4 = GalleryInputFragment.D;
        r110.ga0(false, true, null);
        if (this.l == true) goto L51;
        com.larus.chat.gallery.providers.input.a r111 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(D()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r111 == null) goto L50;
        Intrinsics.checkNotNullParameter(r111, "$this$inputAbility");
        r111.qC();
        Unit r112 = Unit.INSTANCE;
        return;
    L50:
        FLogger.a.e("PreviewBottomProvider", "[inputAbility] failed, cannot get GalleryInputAbility");
        return;
    L51:
        G(new s0(r13, this));
        K(r13);
        N(false);
        return;
    L8:
        if (r1 == SourceType.ATTACHMENT) goto L15;
        if (r1 == SourceType.CAMERA_RESULT) goto L15;
        if (r1 == SourceType.CLOUD_DRIVE) goto L15;
        r2 = false;
        goto L17
    }

    public final void y(FragmentActivity r15, IFlowCamera r16, xy8.d r17, String r18, Bitmap r19, xp9.i r20) {
        ArrayList r4 = new ArrayList();
        String r5 = null;
        if (r17 == null) goto L5;
        GalleryType r6 = r17.e;
    L7:
        if (r6 != GalleryType.Image) goto L23;
        if (r18 != null) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == true) goto L23;
        OutputParam r8 = new OutputParam();
        r8.setResultType(OutputParam.ResultType.PHOTO);
        ImageParam r9 = new ImageParam();
        r9.setPath(r18);
        r9.setBitmap(r19);
        if (r17 == null) goto L20;
        xy8.b r2 = r17.c;
        if (r2 == null) goto L20;
        boolean r3 = Intrinsics.areEqual(r2.e, Boolean.TRUE);
    L21:
        r9.setAiCreation(r3);
        r8.setImageParam(r9);
        r8.setSelected(true);
        r8.setFromAlbum(false);
        r4.add(r8);
    L56:
        Iterator r10 = r20.a.iterator();
    L58:
        if (r10.hasNext() == false) goto L61;
        Uri r11 = (Uri) r10.next();
        OutputParam r12 = new OutputParam();
        r12.setResultType(OutputParam.ResultType.PHOTO);
        ImageParam r13 = new ImageParam();
        r13.setPath(r11.toString());
        r12.setImageParam(r13);
        r12.setSelected(true);
        r12.setFromAlbum(true);
        r4.add(r12);
        goto L58
    L61:
        if (r4.isEmpty() == false) goto L64;
        FLogger.a.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: outputParamList is empty");
        return;
    L64:
        PreviewCameraParamProvider r14 = this.h;
        if (r17 == null) goto L69;
        r14.getClass();
        xy8.b r21 = r17.c;
        if (r21 == null) goto L69;
        boolean r22 = Intrinsics.areEqual(r21.e, Boolean.TRUE);
    L70:
        r14.i = r22;
        PreviewCameraParamProvider r23 = this.h;
        com.larus.chat.gallery.api.q r24 = E();
        if (r24 == null) goto L73;
        String r25 = r24.j();
    L74:
        AttachmentEditType r110 = AttachmentEditType.OTHER;
        if (r110 == AttachmentEditType.MARK) goto L77;
        boolean r111 = true;
    L78:
        InputParam r26 = r23.e(r110, r111, r25);
        if (this.i.g == false) goto L88;
        PreviewCameraParamProvider r27 = this.h;
        com.larus.chat.gallery.api.q r112 = E();
        if (r17 != null) goto L83;
        return;
    L83:
        String r113 = r17.i;
        if (r113 != null) goto L86;
        r113 = r17.b;
    L86:
        r27.b(r26, r112, r17, SetsKt.setOf(r113));
    L88:
        if (this.i.e == false) goto L104;
        if (r17 == null) goto L91;
        GalleryType r28 = r17.e;
    L93:
        if (r28 != GalleryType.Image) goto L104;
        xy8.b r0 = r17.c;
        if (r0 == null) goto L104;
        String r1 = r0.d;
        if (r1 == null) goto L104;
        if (r1.length() <= 0) goto L101;
        boolean r29 = true;
    L102:
        if (r29 == false) goto L104;
        r5 = r1;
        goto L104
    L101:
        r29 = false;
        goto L102
    L91:
        r28 = null;
    L104:
        if (r5 != null) goto L106;
    L109:
        boolean r30 = true;
    L110:
        if (r30 == true) goto L115;
        InputParamExtra r31 = r26.getExtra();
        if (r31 != null) goto L114;
        r31 = new InputParamExtra();
        r26.setExtra(r31);
    L114:
        r31.put(InputParamExtra.KEY_RAW_IMAGE_URI, r5);
        r26.setEnableOriginalImageDeferredEdit(true);
    L115:
        CameraOutputContext r32 = new CameraOutputContext();
        r32.setOutputParamList(r4);
        FLogger r33 = FLogger.a;
        StringBuilder r34 = new StringBuilder("launchMarkPageWithAlbumResult: totalCount=");
        r34.append(r4.size());
        r34.append(", hasCurrentMedia=");
        OutputParam r35 = (OutputParam) CollectionsKt.firstOrNull(r4);
        if (r35 != null) goto L118;
    L120:
        boolean r36 = false;
    L121:
        r34.append(r36);
        r34.append(", albumCount=");
        r34.append(r20.a.size());
        r33.i("PreviewBottomProvider", r34.toString());
        if (this.j.c(ChildResultMode.ALBUM_APPEND) == true) goto L125;
        this.h.k();
        r33.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: pending result unavailable");
        return;
    L125:
        J();
        this.f.c(false);
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L128
        r16.j(r15, r26, r32);     // Catch: Throwable -> L128
        Object r38 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L128
    L130:
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L137;
        this.f.c(true);
        this.h.k();
        this.j.g();
        FLogger.a.e("PreviewBottomProvider", "launchMarkPageWithAlbumResult: result page launch failed", r39);
        return;
    L137:
        return;
    L128:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r38 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L130
    L118:
        if (r35.isFromAlbum() == true) goto L120;
        r36 = true;
        goto L121
    L106:
        if (r5.length() == 0) goto L109;
        r30 = false;
        goto L110
    L77:
        r111 = false;
        goto L78
    L73:
        r25 = null;
    L69:
        r22 = false;
    L20:
        r3 = false;
        goto L21
    L10:
        if (r18.length() == 0) goto L13;
        r7 = false;
    L23:
        if (this.i.c == false) goto L56;
        if (r17 == null) goto L26;
        GalleryType r41 = r17.e;
    L28:
        if (r41 != GalleryType.Video) goto L56;
        xy8.g r42 = r17.d;
        if (r42 == null) goto L33;
        String r43 = r42.f;
        if (r43 == null) goto L33;
    L36:
        if (r43 != null) goto L38;
    L41:
        boolean r44 = true;
    L42:
        if (r44 == true) goto L56;
        OutputParam r45 = new OutputParam();
        r45.setResultType(OutputParam.ResultType.VIDEO);
        VideoParam r46 = new VideoParam();
        r46.setPath(r43);
        xy8.g r47 = r17.d;
        if (r47 == null) goto L46;
        int r48 = r47.j;
    L47:
        r46.setWidth(r48);
        xy8.g r49 = r17.d;
        if (r49 == null) goto L50;
        int r50 = r49.k;
    L51:
        r46.setHeight(r50);
        xy8.g r51 = r17.d;
        if (r51 == null) goto L54;
        double r114 = r51.l;
    L55:
        r46.setDuration((long) (r114 * ((double) GuidePriority.COMMERCE_CREDIT_PRIORITY)));
        r45.setVideoParam(r46);
        r45.setSelected(true);
        r45.setFromAlbum(false);
        r4.add(r45);
        goto L56
    L54:
        r114 = 0.0d;
        goto L55
    L50:
        r50 = 0;
        goto L51
    L46:
        r48 = 0;
        goto L47
    L38:
        if (r43.length() == 0) goto L41;
        r44 = false;
    L33:
        if (r42 == null) goto L35;
        r43 = r42.b;
        goto L36
    L35:
        r43 = null;
        goto L36
    L26:
        r41 = null;
        goto L28
    L5:
        r6 = null;
        goto L7
    }

    public PreviewBottomProvider(com.larus.chat.gallery.impl.preview.input.e0 r3, Long r4, PreviewCameraParamProvider r5, com.larus.chat.gallery.impl.preview.c r6, com.larus.chat.gallery.impl.preview.input.d0 r7, r r8, boolean r9, com.larus.chat.gallery.api.z r10, boolean r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r12 & 64) == 0) goto L9;
        r9 = true;
    L9:
        if ((r12 & 128) == 0) goto L12;
        r10 = null;
    L12:
        if ((r12 & 256) == 0) goto L14;
        r11 = false;
    L14:
        Intrinsics.checkNotNullParameter(r3, "sendStrategy");
        Intrinsics.checkNotNullParameter(r5, "paramProvider");
        Intrinsics.checkNotNullParameter(r6, "albumFlowPolicy");
        Intrinsics.checkNotNullParameter(r7, "sessionController");
        Intrinsics.checkNotNullParameter(r8, "bottomChrome");
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r8;
        this.l = r9;
        this.m = r10;
        this.n = r11;
        this.o = new AlbumHelper();
        this.t = LazyKt.lazy(new h0(this));
        this.u = LazyKt.lazy(new i0(this));
        this.v = LazyKt.lazy(LazyThreadSafetyMode.NONE, new j0(this));
        this.w = LazyKt.lazy(new l0(this));
    }
}
