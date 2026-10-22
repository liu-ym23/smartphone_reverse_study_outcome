package com.larus.uaigc.bean.chat.gallery;

import android.os.Bundle;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationAiEditService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import hy9.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jy9.b;
import jy9.c;
import jy9.e;
import jy9.g;
import jy9.h;
import jy9.i;
import jy9.j;
import jy9.l;
import jy9.m;
import jy9.n;
import jy9.o;
import jy9.p;
import jy9.q;
import jy9.s;
import jy9.t;
import jy9.y;
import jy9.z;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\u000e\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00110\u000f*\u00020\u0007H\u0002J \u0010\u0012\u001a\u00020\u0013*\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002J4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010\u001d\u001a\u00020\u001e*\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u001c\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\"H\u0002J\u001c\u0010#\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"H\u0002J\u0014\u0010)\u001a\u00020\u0017*\u00020\u00072\u0006\u0010(\u001a\u00020\"H\u0002JN\u0010*\u001a\u00020+*\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010,\u001a\u0004\u0018\u00010\t2\"\u0010-\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00110\u000fH\u0002JN\u0010.\u001a\u00020+*\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\"\u0010-\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00110\u000fH\u0002J,\u0010/\u001a\u00020+*\u00020\u00072\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\"H\u0002J\u0016\u00106\u001a\u00020+*\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002¨\u00068"}, d2 = {"Lcom/larus/uaigc/bean/chat/gallery/CreationAiEditServiceImpl;", "Lcom/larus/uaigc/service/ICreationAiEditService;", "<init>", "()V", "getCreationAiEditParams", "Lcom/larus/uaigc/bean/chat/gallery/CreationAiEditParams;", "aiEditContext", "Lcom/larus/uaigc/bean/chat/gallery/AiEditFeatureContext;", "generateImageEditParams", "Lcom/larus/uaigc/bean/chat/gallery/EditorDependency;", "botId", "", "generateImageGenerationParams", "generateVideoEditParams", "buildReplyTrackMapResolver", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "", "buildBeautifyEnv", "Lcom/larus/uaigc/bean/chat/gallery/BeautifyEnv;", "imageEditConfig", "curBotId", "reportEditFunctionClick", "", "report", "Lcom/larus/uaigc/bean/chat/gallery/EditFunctionReport;", "replyTrackMap", "creationTaskId", "reportEditFunctionShow", "buildHitPoint", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "enterMethod", "resolveCreatePageBotId", "openNewChatPage", "", "resolveCreatePageConversationId", "curCvsId", "shouldRetainCreationHomeMemoryForHostDetail", "buildDetailEditExtraBundle", "Landroid/os/Bundle;", "retainCreationHomeMemory", "dismissSourceDetailBeforeHostRoute", "buildVideoEditParams", "Lcom/larus/bmhome/chat/bean/AIEditParams;", "videoEditConfig", "replyTrackMapResolver", "buildImageEditParams", "buildImageBeautifyParams", "beautifyConfig", "Lcom/larus/uaigc/bean/chat/gallery/BeautifyConfig;", "instructionId", "", "buttonNameRes", "showAiEditFunction", "buildVideoExtendParams", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationAiEditServiceImpl implements ICreationAiEditService {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public CreationAiEditServiceImpl() {
    }

    public static Bundle b(boolean r4) {
        Bundle r1 = f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        if (r4 == false) goto L5;
        r1.putBoolean("retain_ai_creation_home_memory", true);
    L5:
        return r1;
    }

    public static z e(String r11) {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L7;
        String r2 = r1.W();
    L8:
        IActionBarService r3 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r11 != null) goto L11;
        String r4 = "";
    L12:
        List r5 = r3.f(r4);
        boolean r6 = true;
        boolean r7 = false;
        if (r5 == null) goto L31;
        Iterator r8 = r5.iterator();
    L16:
        if (r8.hasNext() == false) goto L28;
        Object r9 = r8.next();
        r r10 = ((z0) r9).q;
        if (r10 == null) goto L25;
        Integer r12 = r10.a;
        if (r12 == null) goto L25;
        if (r12.intValue() != 16) goto L25;
        boolean r13 = true;
    L26:
        if (r13 == false) goto L16;
    L29:
        z0 r14 = (z0) r9;
        if (r14 == null) goto L31;
    L49:
        if (r14 == null) goto L51;
    L93:
        r6 = false;
    L94:
        if (r14 == null) goto L98;
        r r15 = r14.q;
        if (r15 == null) goto L98;
        r7 = Intrinsics.areEqual(r15.h, Boolean.TRUE);
    L98:
        if (r7 == true) goto L100;
        return null;
    L100:
        return new z(r14, r6);
    L51:
        if (Intrinsics.areEqual(r2, r11) == true) goto L93;
        List r16 = r3.f(r2);
        if (r16 == null) goto L73;
        Iterator r17 = r16.iterator();
    L56:
        if (r17.hasNext() == false) goto L68;
        Object r18 = r17.next();
        r r19 = ((z0) r18).q;
        if (r19 == null) goto L65;
        Integer r20 = r19.a;
        if (r20 == null) goto L65;
        if (r20.intValue() != 16) goto L65;
        boolean r21 = true;
    L66:
        if (r21 == false) goto L56;
    L69:
        z0 r22 = (z0) r18;
        if (r22 == null) goto L73;
        r14 = r22;
    L91:
        if (r14 == null) goto L93;
    L65:
        r21 = false;
        goto L66
    L68:
        r18 = null;
    L73:
        if (r16 == null) goto L90;
        Iterator r110 = r16.iterator();
    L76:
        if (r110.hasNext() == false) goto L88;
        Object r23 = r110.next();
        r r24 = ((z0) r23).q;
        if (r24 == null) goto L85;
        Integer r25 = r24.a;
        if (r25 == null) goto L85;
        if (r25.intValue() != 4) goto L85;
        boolean r26 = true;
    L86:
        if (r26 == false) goto L76;
    L89:
        r14 = (z0) r23;
    L85:
        r26 = false;
        goto L86
    L88:
        r23 = null;
        goto L89
    L90:
        r14 = null;
    L25:
        r13 = false;
        goto L26
    L28:
        r9 = null;
    L31:
        if (r5 == null) goto L48;
        Iterator r27 = r5.iterator();
    L34:
        if (r27.hasNext() == false) goto L46;
        Object r28 = r27.next();
        r r29 = ((z0) r28).q;
        if (r29 == null) goto L43;
        Integer r30 = r29.a;
        if (r30 == null) goto L43;
        if (r30.intValue() != 4) goto L43;
        boolean r31 = true;
    L44:
        if (r31 == false) goto L34;
    L47:
        r14 = (z0) r28;
    L43:
        r31 = false;
        goto L44
    L46:
        r28 = null;
        goto L47
    L48:
        r14 = null;
        goto L49
    L11:
        r4 = r11;
    L7:
        r2 = null;
        goto L8
    }

    public static void g(y r22) {
        d r2 = ICreationReportService.a.j();
        String r7 = r22.b;
        String r3 = r22.a;
        String r8 = r22.c;
        z r1 = r22.d;
        if (r1 == null) goto L11;
        z0 r4 = r1.a;
        if (r4 == null) goto L11;
        r r5 = r4.q;
        if (r5 == null) goto L11;
        Integer r6 = r5.a;
        if (r6 == null) goto L11;
        String r10 = r6.toString();
    L12:
        z r9 = r22.d;
        if (r9 == null) goto L19;
        z0 r11 = r9.a;
        if (r11 == null) goto L19;
        r r12 = r11.q;
        if (r12 == null) goto L19;
        String r13 = r12.g;
    L20:
        LruCache r14 = ko8.a.a;
        String r15 = ko8.a.h(ko8.a.e);
        Message r16 = r22.e;
        if (r16 == null) goto L23;
        Boolean r17 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r16));
    L24:
        Message r18 = r22.e;
        if (r18 == null) goto L27;
        String r19 = tz9.a.a(r18);
    L28:
        d.a.b(r2, r3, null, r22.f, "picture_detail", r7, r8, null, r10, r13, r15, r17, r19, null, null, null, null, null, null, 1044546);
        return;
    L27:
        r19 = null;
        goto L28
    L23:
        r17 = null;
    L19:
        r13 = null;
    L11:
        r10 = null;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r0v30, types: [jy9.p] */
    /* JADX WARN: Type inference failed for: r15v0, types: [jy9.q] */
    @Override // com.larus.uaigc.service.ICreationAiEditService
    public final e a(final jy9.a r34) {
        Intrinsics.checkNotNullParameter(r34, "aiEditContext");
        BotModel r0 = r34.i();
        Function1 r1 = null;
        if (r0 == null) goto L5;
        final String r9 = r0.getBotId();
    L6:
        e0 r2 = (e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L11;
        LaunchInfo r3 = r2.a;
        if (r3 == null) goto L11;
        String r4 = r3.W();
    L12:
        IActionBarService r5 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r9 != null) goto L15;
        String r6 = "";
    L16:
        List r7 = r5.f(r6);
        if (Intrinsics.areEqual(z2.a.getCreationEditControlConfig().b(), Boolean.TRUE) == true) goto L19;
    L76:
        z r8 = e(r9);
    L77:
        final z r12 = r8;
        z r13 = e(r9);
        IActionBarService r10 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r9 != null) goto L80;
        String r11 = "";
    L81:
        List r14 = r10.f(r11);
        if (r14 == null) goto L99;
        Iterator r15 = r14.iterator();
    L85:
        if (r15.hasNext() == false) goto L97;
        Object r16 = r15.next();
        r r17 = ((z0) r16).q;
        if (r17 == null) goto L94;
        Integer r18 = r17.a;
        if (r18 == null) goto L94;
        if (r18.intValue() != 24) goto L94;
        boolean r19 = true;
    L95:
        if (r19 == false) goto L85;
    L98:
        z0 r20 = (z0) r16;
    L100:
        if (r20 != null) goto L129;
        e0 r21 = (e0) AuthModelDelegate.b.e().getValue();
        if (r21 == null) goto L106;
        LaunchInfo r22 = r21.a;
        if (r22 == null) goto L106;
        String r23 = r22.W();
    L108:
        if (Intrinsics.areEqual(r23, r9) == true) goto L129;
        List r24 = r10.f(r23);
        if (r24 == null) goto L127;
        Iterator r25 = r24.iterator();
    L113:
        if (r25.hasNext() == false) goto L125;
        Object r26 = r25.next();
        r r27 = ((z0) r26).q;
        if (r27 == null) goto L122;
        Integer r28 = r27.a;
        if (r28 == null) goto L122;
        if (r28.intValue() != 24) goto L122;
        boolean r29 = true;
    L123:
        if (r29 == false) goto L113;
    L126:
        r20 = (z0) r26;
    L128:
        boolean r30 = true;
    L130:
        if (r20 == null) goto L134;
        r r31 = r20.q;
        if (r31 == null) goto L134;
        boolean r32 = Intrinsics.areEqual(r31.h, Boolean.TRUE);
    L135:
        if (r32 == false) goto L137;
        final z r110 = new z(r20, r30);
    L138:
        final ?? r111 = new q(r34);
        c r33 = r34.a();
        if (r33 != null) goto L178;
        final q0 r35 = r34.getAdapter();
        if (r35 != null) goto L143;
        r33 = new c("", "", null, null, null, null, new jy9.r());
        goto L178
    L143:
        String r36 = r35.getChatParam().a;
        if (r36 != null) goto L146;
        r36 = "";
    L146:
        Function0 r37 = r35.getHostFragment();
        if (r37 == null) goto L149;
        final Fragment r38 = (Fragment) r37.invoke();
    L150:
        q0.a r39 = r35.getProvider();
        if (r39 == null) goto L155;
        com.larus.bmhome.chat.component.cvs.y r40 = r39.u0();
        if (r40 == null) goto L155;
        wc9.e r41 = r40.h();
    L156:
        q0.a r42 = r35.getProvider();
        if (r42 == null) goto L159;
        final u7 r210 = r42.u3();
    L160:
        if (r38 == null) goto L162;
        final IChatDoubleTabAbility r211 = (IChatDoubleTabAbility) s1a.a.g(r38).getAbility(IChatDoubleTabAbility.class);
    L163:
        q0.a r43 = r35.getProvider();
        if (r43 == null) goto L166;
        final ICoreInputAbility r44 = r43.v0();
    L167:
        if (r44 == null) goto L169;
        Function1 r45 = new s(r44);
    L170:
        if (r38 == null) goto L172;
        final Fragment r112 = r38;
        final String r113 = r36;
        final ICoreInputAbility r212 = r44;
        Function4 r213 = new t(r112, r113, r35, r210, r211, r212);
    L173:
        if (r38 == null) goto L177;
        final FragmentManager r46 = r38.getParentFragmentManager();
        if (r46 == null) goto L177;
        r1 = new g(r34, r46);
    L177:
        String r114 = r36;
        c r47 = new c(r114, r35.getChatParam().b, r41, r45, r213, r1, new h(r34, r38));
    L179:
        b r48 = new b(r9, r13, r111, r47);
        final String r49 = r47.a;
        if (r110 == null) goto L182;
        boolean r115 = true;
    L183:
        final String r50 = r9;
        final z r51 = r110;
        ic8.d r214 = new ic8.d(r115, new m(this, r34, r50, r51, r111, r49), new n(this, r34, r9, r110), false, null, null, 56);
        final String r52 = r47.a;
        if (r12 == null) goto L186;
        boolean r116 = true;
    L187:
        final String r53 = r9;
        ic8.d r117 = new ic8.d(r116, new i(this, r34, r53, r12, r111, r52), new j(this, r34, r9, r12), false, null, null, 56);
        if (r13 == null) goto L194;
        z0 r54 = r13.a;
        if (r54 == null) goto L194;
        r r55 = r54.q;
        if (r55 == null) goto L194;
        boolean r56 = Intrinsics.areEqual(r55.h, Boolean.TRUE);
    L195:
        ic8.d r215 = c(r34, r48, 3, 2131906329, r56);
        if (r13 == null) goto L202;
        z0 r57 = r13.a;
        if (r57 == null) goto L202;
        r r58 = r57.q;
        if (r58 == null) goto L202;
        boolean r59 = Intrinsics.areEqual(r58.h, Boolean.TRUE);
    L203:
        if (r59 == false) goto L212;
        Message r60 = r34.getMessage();
        if (r60 != null) goto L207;
    L209:
        boolean r61 = false;
    L210:
        if (r61 == true) goto L212;
        boolean r62 = true;
    L213:
        ic8.d r118 = c(r34, r48, 2, 2131906326, r62);
        if (r13 == null) goto L220;
        z0 r63 = r13.a;
        if (r63 == null) goto L220;
        r r64 = r63.q;
        if (r64 == null) goto L220;
        boolean r65 = Intrinsics.areEqual(r64.h, Boolean.TRUE);
    L221:
        if (r65 == false) goto L230;
        Message r66 = r34.getMessage();
        if (r66 != null) goto L225;
    L227:
        boolean r67 = false;
    L228:
        if (r67 == true) goto L230;
        boolean r68 = true;
    L232:
        return new e(r214, r117, r118, r215, c(r34, r48, 1, 2131906330, r68), new ic8.d(z2.a.getCreationExtendVideoConfig().b(), null, new o(), false, null, new p(r34), 26));
    L225:
        if (com.larus.bmhome.chat.bean.d.y(r66) != true) goto L227;
        r67 = true;
    L230:
        r68 = false;
    L220:
        r65 = false;
        goto L221
    L207:
        if (com.larus.bmhome.chat.bean.d.y(r60) != true) goto L209;
        r61 = true;
    L212:
        r62 = false;
    L202:
        r59 = false;
    L194:
        r56 = false;
        goto L195
    L186:
        r116 = false;
        goto L187
    L182:
        r115 = false;
        goto L183
    L172:
        r213 = null;
        goto L173
    L169:
        r45 = null;
        goto L170
    L166:
        r44 = null;
        goto L167
    L162:
        r211 = null;
        goto L163
    L159:
        r210 = null;
    L155:
        r41 = null;
        goto L156
    L149:
        r38 = null;
    L178:
        r47 = r33;
        goto L179
    L137:
        r110 = null;
    L134:
        r32 = false;
    L122:
        r29 = false;
        goto L123
    L125:
        r26 = null;
        goto L126
    L127:
        r20 = null;
    L106:
        r23 = null;
    L129:
        r30 = false;
    L94:
        r19 = false;
        goto L95
    L97:
        r16 = null;
        goto L98
    L99:
        r20 = null;
        goto L100
    L80:
        r11 = r9;
        goto L81
    L19:
        if (r7 == null) goto L47;
        Iterator r69 = r7.iterator();
    L22:
        if (r69.hasNext() == false) goto L34;
        Object r70 = r69.next();
        r r119 = ((z0) r70).q;
        if (r119 == null) goto L31;
        Integer r120 = r119.a;
        if (r120 == null) goto L31;
        if (r120.intValue() != 28) goto L31;
        boolean r121 = true;
    L32:
        if (r121 == false) goto L22;
    L35:
        z0 r71 = (z0) r70;
        if (r71 == null) goto L47;
        r r72 = r71.q;
        if (r72 == null) goto L40;
        boolean r73 = Intrinsics.areEqual(r72.h, Boolean.TRUE);
    L41:
        if (r73 == true) goto L44;
        r71 = null;
    L44:
        if (r71 == null) goto L47;
        r8 = new z(r71, false);
        goto L77
    L40:
        r73 = false;
    L31:
        r121 = false;
        goto L32
    L34:
        r70 = null;
    L47:
        if (Intrinsics.areEqual(r4, r9) == true) goto L76;
        List r74 = r5.f(r4);
        if (r74 == null) goto L73;
        Iterator r75 = r74.iterator();
    L52:
        if (r75.hasNext() == false) goto L64;
        Object r76 = r75.next();
        r r77 = ((z0) r76).q;
        if (r77 == null) goto L61;
        Integer r78 = r77.a;
        if (r78 == null) goto L61;
        if (r78.intValue() != 28) goto L61;
        boolean r79 = true;
    L62:
        if (r79 == false) goto L52;
    L65:
        z0 r80 = (z0) r76;
        if (r80 == null) goto L73;
        r r81 = r80.q;
        if (r81 == null) goto L70;
        boolean r82 = Intrinsics.areEqual(r81.h, Boolean.TRUE);
    L71:
        if (r82 == false) goto L73;
    L74:
        if (r80 == null) goto L76;
        r8 = new z(r80, true);
        goto L77
    L70:
        r82 = false;
    L61:
        r79 = false;
        goto L62
    L64:
        r76 = null;
    L73:
        r80 = null;
        goto L74
    L15:
        r6 = r9;
    L11:
        r4 = null;
        goto L12
    L5:
        r9 = null;
        goto L6
    }

    public static void d(jy9.a r2, boolean r3) {
        if (r3 == true) goto L33;
        return;
    L33:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L27
        r2.b();     // Catch: Throwable -> L27
        Fragment r5 = r2.g();     // Catch: Throwable -> L27
        if (r5 == null) goto L8;
        FragmentActivity r6 = r5.getActivity();     // Catch: Throwable -> L27
        if (r6 == null) goto L8;
    L16:
        if (r6 == null) goto L25;
        FragmentManager r7 = r6.getSupportFragmentManager();     // Catch: Throwable -> L27
        if (r7 == null) goto L25;
        Fragment r8 = r7.findFragmentByTag("ChatGalleryDialog");     // Catch: Throwable -> L27
        if (r8 != null) goto L23;
        r8 = r7.findFragmentByTag("ChatCreationPagerFragment");     // Catch: Throwable -> L27
    L23:
        if (r8 == null) goto L25;
        FragmentTransaction r9 = r7.beginTransaction();     // Catch: Throwable -> L27
        r9.remove(r8);     // Catch: Throwable -> L27
        r9.commitAllowingStateLoss();     // Catch: Throwable -> L27
    L25:
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L35;
        FLogger.a.e("CreationAiEditHelper", "dismiss source detail before host route failed", r11);
        return;
    L35:
        return;
    L8:
        q0 r12 = r2.getAdapter();     // Catch: Throwable -> L27
        if (r12 == null) goto L15;
        Function0 r13 = r12.getHostFragment();     // Catch: Throwable -> L27
        if (r13 == null) goto L15;
        Fragment r14 = (Fragment) r13.invoke();     // Catch: Throwable -> L27
        if (r14 == null) goto L15;
        r6 = r14.getActivity();     // Catch: Throwable -> L27
    L15:
        r6 = null;
    L27:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    public static void f(y r26, Map r27, String r28) {
        d r3 = ICreationReportService.a.j();
        String r4 = r26.a;
        String r8 = r26.b;
        String r9 = r26.c;
        z r2 = r26.d;
        if (r2 == null) goto L11;
        z0 r5 = r2.a;
        if (r5 == null) goto L11;
        r r6 = r5.q;
        if (r6 == null) goto L11;
        Integer r7 = r6.a;
        if (r7 == null) goto L11;
        String r11 = r7.toString();
    L12:
        z r10 = r26.d;
        if (r10 == null) goto L19;
        z0 r12 = r10.a;
        if (r12 == null) goto L19;
        r r13 = r12.q;
        if (r13 == null) goto L19;
        String r14 = r13.g;
    L20:
        LruCache r15 = ko8.a.a;
        String r16 = ko8.a.h(ko8.a.e);
        Message r17 = r26.e;
        if (r17 == null) goto L23;
        Boolean r18 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r17));
    L24:
        Message r19 = r26.e;
        if (r19 == null) goto L27;
        String r110 = tz9.a.a(r19);
    L28:
        String r20 = r26.f;
        if (r27 == null) goto L31;
        String r111 = (String) r27.get("recommend_from");
    L32:
        if (r27 == null) goto L34;
        String r112 = (String) r27.get("from_template_id");
    L35:
        if (r27 == null) goto L37;
        String r113 = (String) r27.get("template_rec_extra");
    L38:
        if (r27 == null) goto L40;
        String r114 = (String) r27.get("template_rec_req_id");
    L41:
        d.a.a(r3, r4, null, r20, "picture_detail", r8, r9, null, r11, r14, r16, r18, r110, r111, r112, r114, r113, null, r28, null, null, null, 3997762);
        return;
    L40:
        r114 = null;
        goto L41
    L37:
        r113 = null;
        goto L38
    L34:
        r112 = null;
        goto L35
    L31:
        r111 = null;
        goto L32
    L27:
        r110 = null;
        goto L28
    L23:
        r18 = null;
    L19:
        r14 = null;
    L11:
        r11 = null;
        goto L12
    }

    public final ic8.d c(final jy9.a r15, final b r16, final int r17, final int r18, boolean r19) {
        z r0 = r16.b;
        if (r0 != null) goto L5;
    L7:
        final boolean r4 = false;
    L9:
        return new ic8.d(r19, new jy9.f(r17, r15, r16, r4, this, r18), new l(this, r15, r18, r16, r17), false, null, null, 56);
    L5:
        if (r0.b != true) goto L7;
        r4 = true;
        goto L9
    }
}
