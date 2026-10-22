package com.larus.bmhome.instruction.handler;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.instruction.c2;
import com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.instruction.service.IInstructionService;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.g3;
import com.larus.platform.service.k2;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s extends i {
    public static final /* synthetic */ int o = 0;
    public final com.larus.bmhome.instruction.p j;
    public final AiBeautifyPickPhotoHelper k;
    public z0 l;
    public boolean m;
    public com.larus.bmhome.instruction.n n;

    public static final class a {
    }

    public static final class b implements zs8.a {
        public final /* synthetic */ s a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        @Override // zs8.a
        public final String b() {
            return "chat";
        }

        @Override // zs8.a
        public final String d() {
            return null;
        }

        @Override // zs8.a
        public final String e() {
            return null;
        }

        @Override // zs8.a
        public final String f() {
            return null;
        }

        @Override // zs8.a
        public final String g() {
            return null;
        }

        @Override // zs8.a
        public final String getClickFrom() {
            return "";
        }

        @Override // zs8.a
        public final String getTemplateType() {
            return null;
        }

        @Override // zs8.a
        public final String h() {
            return null;
        }

        @Override // zs8.a
        public final String i() {
            return null;
        }

        @Override // zs8.a
        public final String j() {
            return null;
        }

        @Override // zs8.a
        public final String k() {
            return null;
        }

        @Override // zs8.a
        public final boolean l() {
            return false;
        }

        @Override // zs8.a
        public final String m() {
            return null;
        }

        @Override // zs8.a
        public final String n() {
            return null;
        }

        @Override // zs8.a
        public final String o() {
            return null;
        }

        @Override // zs8.a
        public final String p() {
            return null;
        }

        @Override // zs8.a
        public final String a() {
            com.larus.bmhome.instruction.n r0 = this.a.n;
            if (r0 == null) goto L7;
            com.larus.bmhome.instruction.a r1 = r0.e;
            if (r1 == null) goto L7;
            return r1.c;
        L7:
            return null;
        }

        @Override // zs8.a
        public final String c() {
            com.larus.bmhome.instruction.n r0 = this.a.n;
            if (r0 == null) goto L7;
            com.larus.bmhome.instruction.a r1 = r0.e;
            if (r1 == null) goto L7;
            return r1.d;
        L7:
            return null;
        }

        @Override // zs8.a
        public final String getEnterMethod() {
            com.larus.bmhome.instruction.n r0 = this.a.n;
            if (r0 == null) goto L7;
            com.larus.bmhome.instruction.a r1 = r0.e;
            if (r1 == null) goto L7;
            String r2 = r1.b;
        L8:
            if (r2 != null) goto L11;
            return "";
        L11:
            return r2;
        L7:
            r2 = null;
            goto L8
        }

        @Override // zs8.a
        public final String Y1() {
            return this.d;
        }

        @Override // zs8.a
        public final String getBotId() {
            return this.c;
        }

        @Override // zs8.a
        public final String getChatType() {
            return this.b;
        }

        public b(s r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [com.larus.bmhome.instruction.handler.o] */
    @Override // com.larus.bmhome.instruction.handler.m
    public final void a(com.larus.bmhome.instruction.n r9) {
        Intrinsics.checkNotNullParameter(r9, "inputData");
        this.n = r9;
        com.larus.bmhome.instruction.a r0 = r9.e;
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.i;
    L6:
        this.m = r2;
        String r3 = null;
        if (r0 == null) goto L9;
        Integer r4 = Integer.valueOf(r0.a);
    L10:
        if (r4 == null) goto L12;
        z0 r5 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(r4.intValue());
    L13:
        this.l = r5;
        com.larus.bmhome.instruction.a r6 = r9.e;
        if (r6 == null) goto L16;
        final boolean r7 = r6.j;
    L17:
        if (r6 == null) goto L19;
        final int r8 = r6.k;
    L20:
        if (r6 == null) goto L22;
        String r10 = r6.g;
    L23:
        if (r10 == null) goto L29;
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("feedLandingTabId: ");
        com.larus.bmhome.instruction.a r13 = r9.e;
        if (r13 == null) goto L27;
        r3 = r13.g;
    L27:
        r12.append(r3);
        r11.i("OpenBySchemaActionHandler", r12.toString());
        g(CollectionsKt.emptyList());
        return;
    L29:
        if (r6 != null) goto L31;
    L33:
        if (r1 == false) goto L35;
        final ?? r14 = new o(this, r7, r8);
        k2 r15 = k2.a;
        g3.a.a(d(), null, false, null, false, new r(r14), 30);
        return;
    L35:
        g(CollectionsKt.emptyList());
        return;
    L31:
        if (r6.h != true) goto L33;
        r1 = true;
        goto L33
    L22:
        r10 = null;
        goto L23
    L19:
        r8 = 0;
        goto L20
    L16:
        r7 = false;
        goto L17
    L12:
        r5 = null;
        goto L13
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public final void g(List<? extends Uri> r60) {
        List<? extends Uri> r1 = r60;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r10.add(((Uri) r2.next()).toString());
        goto L4
    L6:
        ChatParam r3 = e().a(ChatParam.class);
        com.larus.bmhome.instruction.n r4 = this.n;
        if (r4 == null) goto L12;
        com.larus.bmhome.instruction.a r5 = r4.e;
        if (r5 == null) goto L12;
        String r6 = r5.o;
        if (r6 == null) goto L12;
    L20:
        if (r3 == null) goto L23;
        String r7 = r3.b;
        if (r7 == null) goto L23;
    L29:
        if (r3 == null) goto L32;
        String r8 = r3.e;
        if (r8 == null) goto L32;
    L33:
        z0 r9 = this.l;
        if (r9 == null) goto L128;
        ICreationWorkflowService.Companion r11 = ICreationWorkflowService.a;
        com.larus.bmhome.instruction.n r12 = this.n;
        if (r12 == null) goto L40;
        com.larus.bmhome.instruction.a r13 = r12.e;
        if (r13 == null) goto L40;
        boolean r20 = r13.e;
    L41:
        FragmentActivity r21 = d().requireActivity();
        ChatParam r24 = new ChatParam(r6, r7, null, null, r8, 236);
        String r25 = (String) CollectionsKt.firstOrNull(r10);
        com.larus.bmhome.instruction.n r14 = this.n;
        if (r14 == null) goto L46;
        com.larus.bmhome.instruction.a r15 = r14.e;
        if (r15 == null) goto L46;
        String r16 = r15.l;
    L47:
        String r17 = "";
        if (r16 != null) goto L50;
        String r18 = "";
    L51:
        if (r14 == null) goto L55;
        com.larus.bmhome.instruction.a r19 = r14.e;
        if (r19 == null) goto L55;
        Integer r26 = Integer.valueOf(r19.f);
    L56:
        com.larus.bmhome.instruction.n r22 = this.n;
        if (r22 == null) goto L59;
        String r23 = r22.d;
    L60:
        if (r23 != null) goto L62;
        r23 = "";
    L62:
        Uri r27 = UriProtector.parse(r23);
        Bundle r110 = new Bundle();
        if (StringsKt.contains$default(r27.toString(), "flow/creation_template", false, 2, null) == false) goto L65;
        r110.putBoolean("is_creation_template", true);
    L65:
        com.larus.bmhome.actionbar.model.r r28 = r9.q;
        if (r28 == null) goto L68;
        boolean r29 = Intrinsics.areEqual(r28.j, Boolean.TRUE);
    L69:
        if (r29 == false) goto L71;
        r110.putBoolean("template_enhance", true);
    L71:
        Iterator r30 = UriProtector.getQueryParameterNames(r27).iterator();
    L73:
        if (r30.hasNext() == false) goto L79;
        String r111 = (String) r30.next();
        if (Intrinsics.areEqual(r111, "actionbar_instruction_type") == true) goto L73;
        if (Intrinsics.areEqual(r111, "prompt") == true) goto L73;
        r110.putString(r111, UriProtector.getQueryParameter(r27, r111));
        goto L73
    L79:
        com.larus.bmhome.instruction.n r31 = this.n;
        if (r31 == null) goto L84;
        com.larus.bmhome.instruction.a r32 = r31.e;
        if (r32 == null) goto L84;
        String r40 = r32.g;
    L85:
        b r112 = new b(this, r8, r7, r6);
        Pair[] r33 = new Pair[1];
        if (r31 == null) goto L88;
        String r34 = r31.d;
    L89:
        if (r34 != null) goto L91;
        r34 = "";
    L91:
        Uri r35 = UriProtector.parse(r34);
        if (r35 == null) goto L94;
        String r36 = com.larus.bmhome.creative.utils.a.a(r35);
    L95:
        if (r36 == null) goto L98;
        r17 = r36;
    L98:
        r33[0] = TuplesKt.to("outer_link_source", r17);
        Map r210 = MapsKt.mutableMapOf(r33);
        com.larus.bmhome.instruction.n r37 = this.n;
        if (r37 == null) goto L105;
        com.larus.bmhome.instruction.a r38 = r37.e;
        if (r38 == null) goto L105;
        Pair<Integer, Integer> r39 = r38.n;
        if (r39 == null) goto L105;
        Integer r211 = (Integer) r39.getFirst();
    L106:
        com.larus.bmhome.instruction.n r41 = this.n;
        if (r41 == null) goto L113;
        com.larus.bmhome.instruction.a r42 = r41.e;
        if (r42 == null) goto L113;
        Pair<Integer, Integer> r43 = r42.n;
        if (r43 == null) goto L113;
        Integer r310 = (Integer) r43.getSecond();
    L114:
        by7.e r44 = d();
        if ((r44 instanceof by7.e) == false) goto L117;
        by7.e r45 = r44;
    L118:
        r11.f0(new ny9.b(r20, r21, r9, r24, false, false, null, r18, null, null, null, null, null, r26, null, null, null, r25, r10, false, false, r112, r45, r110, false, r210, r211, r310, false, null, false, null, null, null, null, null, null, r40, null, null, null, null, null, null, e().a(ChatPageContext.class), null, d(), null, null, false, -249962656, 241631));
        return;
    L117:
        r45 = null;
    L113:
        r310 = null;
    L105:
        r211 = null;
        goto L106
    L94:
        r36 = null;
        goto L95
    L88:
        r34 = null;
    L84:
        r40 = null;
        goto L85
    L68:
        r29 = false;
        goto L69
    L59:
        r23 = null;
    L55:
        r26 = null;
        goto L56
    L50:
        r18 = r16;
    L46:
        r16 = null;
    L40:
        r20 = false;
        goto L41
    L128:
        return;
    L32:
        r8 = "default";
    L23:
        com.larus.bmhome.chat.component.cvs.y r46 = b();
        if (r46 == null) goto L28;
        BotModel r47 = r46.j0();
        if (r47 == null) goto L28;
        r7 = r47.getBotId();
    L28:
        r7 = null;
    L12:
        if (r3 == null) goto L14;
        r6 = r3.a;
    L15:
        if (r6 != null) goto L20;
        com.larus.bmhome.chat.component.cvs.y r48 = b();
        if (r48 == null) goto L19;
        r6 = r48.Y1();
        goto L20
    L19:
        r6 = null;
        goto L20
    L14:
        r6 = null;
        goto L15
    }

    public s(com.larus.bmhome.instruction.p r2, AiBeautifyPickPhotoHelper r3) {
        Intrinsics.checkNotNullParameter(r2, "instructionCoreAbility");
        super(r2);
        this.j = r2;
        this.k = r3;
        if (r3 == null) goto L5;
        r3.b = new p(this);
    L5:
        if (r3 == null) goto L8;
        r3.c = new q(this);
        return;
    }

    public final void f(List<? extends Uri> r57, boolean r58) {
        if (r58 == false) goto L131;
        com.larus.bmhome.instruction.n r0 = this.n;
        Long r1 = null;
        if (r0 == null) goto L9;
        com.larus.bmhome.instruction.a r2 = r0.e;
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.a);
    L11:
        if (r3 != null) goto L13;
        FLogger.a.e("OpenBySchemaActionHandler", "albumDirectSendMsg failed, final instructionType is null");
        return;
    L13:
        com.larus.bmhome.instruction.n r4 = this.n;
        if (r4 == null) goto L19;
        com.larus.bmhome.instruction.a r5 = r4.e;
        if (r5 == null) goto L19;
        String r6 = r5.b;
        if (r6 == null) goto L19;
    L20:
        if (r4 == null) goto L25;
        com.larus.bmhome.instruction.a r7 = r4.e;
        if (r7 == null) goto L25;
        String r8 = r7.l;
        if (r8 == null) goto L25;
    L26:
        com.larus.bmhome.chat.component.cvs.y r9 = b();
        if (r9 == null) goto L29;
        wc9.e r10 = r9.h();
    L30:
        if (r10 == null) goto L32;
        String r11 = r10.a;
    L33:
        z0 r12 = this.l;
        if (r12 == null) goto L36;
        com.larus.bmhome.actionbar.model.r r13 = r12.q;
    L38:
        if (r11 != null) goto L40;
    L43:
        boolean r14 = true;
    L44:
        if (r14 == true) goto L130;
        if (r13 == null) goto L130;
        IInstructionService.Companion r15 = IInstructionService.a;
        int r16 = r3.intValue();
        com.larus.bmhome.instruction.n r17 = this.n;
        if (r17 == null) goto L52;
        aq8.e r18 = r17.b;
        if (r18 == null) goto L52;
        String r19 = r18.d;
    L53:
        gq8.a r110 = gq8.a.a;
        Integer r111 = Integer.valueOf(r16);
        r110.getClass();
        Map r112 = gq8.a.b(r111, r19, null);
        if (r112 == null) goto L81;
        Map r113 = MapsKt.toMutableMap(r112);
        if (r113 == null) goto L81;
        if (r16 == 4) goto L133;
    L82:
        com.larus.bmhome.view.actionbar.edit.b r20 = IInstructionService.a.a(r15, r13, new com.larus.bmhome.view.actionbar.edit.d(r113), null, null, 12);
        ArrayList r114 = new ArrayList();
        Iterator<T> r21 = r57.iterator();
    L84:
        if (r21.hasNext() == false) goto L86;
        String r115 = vqc.d.d(AppHost.a.getApplication(), (Uri) r21.next());
        ImFileUtil r116 = ImFileUtil.a;
        PolarisFileWrapper r117 = new PolarisFileWrapper(r115);
        r116.getClass();
        r114.add(new UplinkFileEntity(Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue()), new UplinkEntityContent(null, new Image(null, ImFileUtil.g(r117), null, new ImageObj(null, 0, 0, null, null, 31, null), null, r115, null, null, null, null, null, null, null, null, 16341, null), 1, null), null, null, Integer.valueOf(FileReviewState.DEFAULT.getValue()), Integer.valueOf(FileParseState.DEFAULT.getValue()), 0, Integer.valueOf(UpLinkState.PROCESSING.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r115)), null, null, null, 15116, null));
        goto L84
    L86:
        CustomMultiAttachmentInfo r22 = new CustomMultiAttachmentInfo("album", r6, new NestedFileContent(r114, null, false, null, 14, null), false, false, false, false, null, 248, null);
        com.larus.bmhome.instruction.p r23 = this.j;
        z0 r118 = this.l;
        r23.getClass();
        String r119 = com.larus.bmhome.instruction.p.c(r118, r8, r20);
        Map<String, String> r24 = MapsKt.emptyMap();
        z0 r25 = this.l;
        if (r25 == null) goto L93;
        com.larus.bmhome.actionbar.model.r r26 = r25.q;
        if (r26 == null) goto L93;
        Integer r27 = r26.a;
        if (r27 == null) goto L93;
        int r120 = r27.intValue();
    L94:
        c2 r121 = c2.a;
        z0 r28 = this.l;
        if (r28 == null) goto L97;
        String r29 = r28.b;
    L98:
        if (r29 != null) goto L100;
        String r122 = "";
    L101:
        if (r28 == null) goto L107;
        com.larus.bmhome.actionbar.model.r r30 = r28.q;
        if (r30 == null) goto L107;
        Integer r31 = r30.a;
        if (r31 == null) goto L107;
        String r32 = r31.toString();
    L108:
        if (r32 != null) goto L110;
        String r123 = "";
    L111:
        z0 r33 = this.l;
        if (r33 == null) goto L116;
        com.larus.bmhome.actionbar.model.r r34 = r33.q;
        if (r34 == null) goto L116;
        Integer r35 = r34.a;
    L117:
        com.larus.bmhome.actionbar.model.r r36 = com.larus.bmhome.instruction.j.a.b(r35, r119, null, r13);
        if (r36 == null) goto L120;
        String r124 = HttpExtKt.p(r36);
    L121:
        z0 r37 = this.l;
        if (r37 == null) goto L124;
        r1 = r37.a;
    L124:
        ICoreInputAbility.OnSendParams r38 = new ICoreInputAbility.OnSendParams(r119, "", null, null, null, r121.b(r122, r123, r124, false, r24, r1), null, null, r120, false, null, false, false, false, null, null, null, null, false, r6, null, null, null, null, "chat", null, r22, null, null, e().a(ChatPageContext.class), null, null, null, -621281600, 1, null);
        ICreationPageService.a.getClass();
        if (ICreationPageService.a.a() == false) goto L127;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d()), null, null, new OpenBySchemaActionHandler$albumDirectSendMsg$2(this, r11, r38, r6, r22, r24, null), 3, null);
        return;
    L127:
        ICoreInputAbility r39 = c();
        if (r39 == null) goto L138;
        r39.E0(r38);
        return;
    L138:
        return;
    L120:
        r124 = null;
    L116:
        r35 = null;
        goto L117
    L110:
        r123 = r32;
    L107:
        r32 = null;
        goto L108
    L100:
        r122 = r29;
        goto L101
    L97:
        r29 = null;
    L93:
        r120 = 0;
        goto L94
    L133:
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L64
        ouc.v r41 = xt7.d.b;     // Catch: Throwable -> L64
        juc.c r125 = juc.v.c(Reflection.typeOf(aq8.g.class));     // Catch: Throwable -> L64
        Intrinsics.checkNotNull(r125, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");     // Catch: Throwable -> L64
        juc.c r126 = r125;     // Catch: Throwable -> L64
        if (r19 != null) goto L62;
        r19 = "";
    L62:
        Object r42 = Result.constructor-impl((aq8.g) r41.c(r126, r19));     // Catch: Throwable -> L64
    L67:
        if (Result.isFailure-impl(r42) == false) goto L69;
        r42 = null;
    L69:
        aq8.g r43 = (aq8.g) r42;
        if (r43 == null) goto L72;
        String r44 = r43.b;
    L73:
        if (r44 != null) goto L75;
    L78:
        boolean r45 = true;
    L79:
        if (r45 == false) goto L82;
        r113.put("2", MapsKt.mapOf(TuplesKt.to("match_all_id", MapsKt.mapOf(TuplesKt.to("default_select_id", TriggerSendLoading.NO_LOADING)))));
        goto L82
    L75:
        if (r44.length() == 0) goto L78;
        r45 = false;
        goto L79
    L72:
        r44 = null;
    L64:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(th));
    L81:
        r113 = null;
    L52:
        r19 = null;
    L130:
        FLogger.a.e("OpenBySchemaActionHandler", "albumDirectSendMsg failed, conversationId: " + r11 + ", instructionConf: " + r13);
        return;
    L40:
        if (r11.length() == 0) goto L43;
        r14 = false;
        goto L44
    L36:
        r13 = null;
        goto L38
    L32:
        r11 = null;
        goto L33
    L29:
        r10 = null;
    L25:
        r8 = "";
    L19:
        r6 = "";
    L9:
        r3 = null;
        goto L11
    L131:
        g(r57);
    }
}
