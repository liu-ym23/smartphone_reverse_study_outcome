package com.larus.bmhome.clarification;

import android.content.Context;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder$a$a;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.model.UploadUiStyle;
import com.larus.platform.model.office.AiFilePreviewScene;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import v19.i5;
import v19.m5;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p1 implements BaseResourceViewHolder.a {
    public final /* synthetic */ ClarificationComponent a;
    public final /* synthetic */ int b;

    public p1(ClarificationComponent r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean b(String r1, View r2) {
        BaseResourceViewHolder$a$a.a(r1, r2);
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [com.larus.bmhome.clarification.r, kotlin.jvm.functions.Function0] */
    public final void a(String r138, int r139, final View r140) {
        Intrinsics.checkNotNullParameter(r138, "key");
        Intrinsics.checkNotNullParameter(r140, "v");
        boolean r11 = false;
        String r12 = null;
        Object r13 = null;
        String r14 = null;
        r14 = null;
        wc9.e r15 = null;
        r12 = null;
        switch(r139) {
            case 101: goto L182;
            case 102: goto L173;
            case 103: goto L38;
            case 104: goto L5;
            case 105: goto L38;
            case 106: goto L38;
            default: goto L264;
        };
    L5:
        ClarificationAttachmentManager r5 = this.a.H;
        if (r5 == null) goto L241;
        int r7 = this.b;
        Intrinsics.checkNotNullParameter(r138, "fileIdentifier");
        if (r5.j == true) goto L265;
        d2 r4 = r5.b.a;
        if (r4 == null) goto L266;
        z1 r8 = (z1) CollectionsKt.getOrNull(r4.l, r7);
        if (r8 == null) goto L267;
        Iterator<T> r9 = r8.l.d.iterator();
    L18:
        if (r9.hasNext() == false) goto L22;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r10).getFileIdentifier(), r138) == false) goto L18;
        r13 = r10;
    L22:
        UplinkFileEntity r16 = (UplinkFileEntity) r13;
        if (r16 == null) goto L268;
        r16.setUpLinkStatus(Integer.valueOf(UpLinkState.PROCESSING.getValue()));
        r16.setUpLinkProcess(1);
        r5.s(r7, r16);
        if (r16.getUri() == null) goto L28;
        r5.r(r8.h, r16, "clarification_retry");
        return;
    L28:
        String r17 = yc9.l1.d(r16);
        if (r17 != null) goto L31;
    L32:
        r11 = true;
    L33:
        if (r11 == false) goto L35;
        FLogger.a.w("ClarificationAttachMgr", "retry attachment ignored, local path empty, pageIndex=" + r7 + ", fileIdentifier=" + r138);
        return;
    L35:
        y r18 = (y) r5.f.invoke();
        com.larus.bmhome.chat.component.bottom.multimodal.upload.m r19 = r5.i(r8.h, r16, "clarification_retry");
        CoroutineScope r1 = (CoroutineScope) r5.e.invoke();
        if (r1 == null) goto L244;
        BuildersKt.launch$default(r1, Dispatchers.getIO(), null, new ClarificationAttachmentManager$retryAttachment$1(r17, r16, r19, r4, r18, r8, null), 2, null);
        return;
    L244:
        return;
    L31:
        if (StringsKt.isBlank(r17) == false) goto L33;
    L268:
        return;
    L267:
        return;
    L266:
        return;
    L265:
        return;
    L241:
        return;
    L38:
        ClarificationAttachmentManager r20 = this.a.H;
        if (r20 == null) goto L246;
        int r21 = this.b;
        Intrinsics.checkNotNullParameter(r138, "fileIdentifier");
        if (r20.j == true) goto L269;
        final UplinkFileEntity r6 = r20.l(r21, r138);
        if (r6 != null) goto L46;
        FLogger.a.w("ClarificationAttachMgr", "open attachment ignored, entity missing, pageIndex=" + r21 + ", fileIdentifier=" + r138);
        return;
    L46:
        final t r110 = r20.i;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r6, "entity");
        if (n1.d(r6) == false) goto L72;
        final Image r2 = yc9.l1.c(r6);
        if (r2 == null) goto L51;
        String r111 = r2.localResPath;
    L52:
        com.larus.bmhome.chat.component.bottom.multimodal.g r3 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r110.d.invoke();
        if (r3 != null) goto L55;
    L57:
        boolean r23 = false;
    L58:
        y r22 = (y) r110.c.invoke();
        if (r22 == null) goto L63;
        BotModel r24 = r22.j0();
        if (r24 == null) goto L63;
        r14 = r24.getBotId();
    L63:
        final String r25 = r14;
        if (m5.c(r111) == false) goto L66;
        r110.b.b(r110.a, r111, r6.getFileIdentifier(), true, r25, false, r23);
        return;
    L66:
        if (r2 == null) goto L249;
        String r26 = r2.key;
        if (r26 == null) goto L270;
        final boolean r112 = r23;
        FlowDriveSdkService.a.z(r26, FlowDriveFileType.IMAGE, LifecycleOwnerKt.getLifecycleScope(r110.a), new s(r110, r2, r6, r25, r112), null);
        return;
    L270:
        return;
    L249:
        return;
    L55:
        if (r3.ld() != true) goto L57;
        r23 = true;
        goto L58
    L51:
        r111 = null;
        goto L52
    L72:
        if (n1.e(r6) == false) goto L89;
        FragmentActivity r113 = r110.a.getActivity();
        if (r113 == null) goto L271;
        y r27 = (y) r110.c.invoke();
        if (r27 == null) goto L81;
        BotModel r28 = r27.j0();
        if (r28 == null) goto L81;
        String r114 = r28.getBotId();
    L83:
        if (r27 == null) goto L85;
        BotModel r29 = r27.j0();
    L86:
        if (r27 == null) goto L88;
        r15 = r27.h();
    L88:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110.a), Dispatchers.getMain(), null, new ClarificationAttachmentPreviewer$openVideo$1(r113, r110, r6, new c4(r114, "", "chat", r29, r15, "click_addition_video", "1", null, null, null, null, null, null, null, 16256), null), 2, null);
        return;
    L85:
        r29 = null;
    L81:
        r114 = null;
        goto L83
    L271:
        return;
    L89:
        Context r30 = r110.a.getContext();
        if (r30 == null) goto L272;
        UplinkEntityContent r31 = r6.getUplinkEntityContent();
        if (r31 == null) goto L252;
        final UplinkFileInfo r32 = r31.getUplinkFileInfo();
        if (r32 == null) goto L273;
        ?? r33 = new r(r110, r6, r32);
        String r34 = r32.getTosKey();
        if (r34 != null) goto L100;
    L110:
        String r115 = null;
    L111:
        Map r35 = r6.getExtra();
        if (r35 == null) goto L114;
        String r36 = (String) r35.get("originFileTypeString");
    L115:
        y r37 = (y) r110.c.invoke();
        if (r37 == null) goto L118;
        wc9.e r38 = r37.h();
    L119:
        Map r39 = r6.getExtra();
        if (r39 == null) goto L122;
        String r40 = (String) r39.get("drive_uplink_info");
    L123:
        if (r40 != null) goto L125;
    L128:
        boolean r116 = true;
    L129:
        if (r116 == true) goto L142;
        FlowDriveSdkService r41 = FlowDriveSdkService.a;
        if (r38 == null) goto L133;
        String r42 = r38.a;
    L134:
        if (r37 == null) goto L138;
        BotModel r43 = r37.j0();
        if (r43 == null) goto L138;
        r12 = r43.getBotId();
    L138:
        r41.getClass();
        if (FlowDriveSdkService.B(r30, r40, r42, r12) == true) goto L253;
        r33.invoke();
        return;
    L253:
        return;
    L133:
        r42 = null;
        goto L134
    L142:
        if (CollectionsKt.contains(SetsKt.setOf(new Integer[]{Integer.valueOf(FileType.FileTypeFile.getValue()), Integer.valueOf(FileType.FileTypeAudio.getValue())}), r32.getFileType()) == false) goto L172;
        if (r115 == null) goto L172;
        int r44 = bq9.a.a;
        if (yc9.l1.k(r36) == true) goto L172;
        if (r38 != null) goto L149;
    L151:
        if (r11 == false) goto L153;
        AiFilePreviewScene r45 = AiFilePreviewScene.P2P_CHAT;
    L154:
        AiFilePreviewScene r117 = r45;
        FlowDriveSdkService r46 = FlowDriveSdkService.a;
        LifecycleCoroutineScope r47 = LifecycleOwnerKt.getLifecycleScope(r110.a);
        String r118 = r32.getFileName();
        String r210 = r32.getMimeType();
        String r211 = r32.getResourceId();
        if (r38 == null) goto L161;
        String r48 = r38.a;
        if (r48 == null) goto L161;
        if ((!StringsKt.isBlank(r48)) == false) goto L161;
        String r212 = r48;
    L162:
        if (r37 == null) goto L170;
        BotModel r49 = r37.j0();
        if (r49 == null) goto L170;
        String r50 = r49.getBotId();
        if (r50 == null) goto L170;
        if ((true ^ StringsKt.isBlank(r50)) == false) goto L170;
        String r213 = r50;
    L171:
        r46.j(r30, r47, new cr9.a(r115, r117, r118, r210, null, r211, r212, r213, null, 272), r33);
        return;
    L170:
        r213 = null;
    L161:
        r212 = null;
        goto L162
    L153:
        r45 = AiFilePreviewScene.AI_CHAT;
        goto L154
    L149:
        if (ve8.c.a(r38) != true) goto L151;
        r11 = true;
    L172:
        r33.invoke();
        return;
    L125:
        if (StringsKt.isBlank(r40) == true) goto L128;
        r116 = false;
        goto L129
    L122:
        r40 = null;
        goto L123
    L118:
        r38 = null;
        goto L119
    L114:
        r36 = null;
        goto L115
    L100:
        if ((!StringsKt.isBlank(r34)) == false) goto L107;
        Integer r51 = r6.getUpLinkStatus();
        int r52 = UpLinkState.SUCCESS.getValue();
        if (r51 == null) goto L107;
        if (r51.intValue() != r52) goto L107;
        boolean r53 = true;
    L108:
        if (r53 == false) goto L110;
        r115 = r34;
    L107:
        r53 = false;
        goto L108
    L273:
        return;
    L252:
        return;
    L272:
        return;
    L269:
        return;
    L246:
        return;
    L173:
        ClarificationAttachmentManager r54 = this.a.H;
        if (r54 == null) goto L257;
        int r55 = this.b;
        Intrinsics.checkNotNullParameter(r138, "fileIdentifier");
        if (r54.j == true) goto L274;
        UplinkFileEntity r56 = r54.l(r55, r138);
        if (r56 == null) goto L275;
        ResourceUploader.c(r138);
        r54.p(r55, r138);
        ClarificationAttachmentManager.j(r56);
        return;
    L275:
        return;
    L274:
        return;
    L257:
        return;
    L182:
        final ClarificationComponent r119 = this.a;
        final int r57 = this.b;
        d2 r58 = r119.n.a;
        if (r58 == null) goto L259;
        List<z1> r59 = r58.l;
        if (r59 == null) goto L260;
        z1 r60 = (z1) CollectionsKt.getOrNull(r59, r57);
        if (r60 == null) goto L276;
        com.larus.bmhome.chat.component.bottom.multimodal.g r61 = r119.r5();
        if (r61 == null) goto L192;
        int r62 = r61.zv(true, null);
    L194:
        if (r60.l.d.size() < r62) goto L203;
        Intrinsics.checkNotNullParameter(r119, "<this>");
        Context r63 = com.larus.ui.arch.component.internal.attach.a.b(r119, r119).getContext();
        if (r63 == null) goto L277;
        com.larus.bmhome.chat.component.bottom.multimodal.g r64 = r119.r5();
        if (r64 == null) goto L261;
        String r65 = r64.mS(true, null);
        if (r65 == null) goto L262;
        t19.s.a.getClass();
        t19.s.t(r63, r65);
        return;
    L262:
        return;
    L261:
        return;
    L277:
        return;
    L203:
        UploadUiStyle.a r66 = UploadUiStyle.Companion;
        int r67 = z2.a.getLarkDriveConfig().e();
        r66.getClass();
        UploadUiStyle r68 = UploadUiStyle.a.a(r67);
        if (r68 == UploadUiStyle.LOCAL_DRIVE) goto L208;
        if (r68 == UploadUiStyle.LOCAL_DRIVE_RECENT) goto L208;
    L210:
        boolean r69 = false;
    L211:
        final List r70 = CollectionsKt.listOf(new FlowDriveFileType[]{FlowDriveFileType.IMAGE, FlowDriveFileType.VIDEO, FlowDriveFileType.FILE});
        final int r71 = r60.l.d.size();
        Context r72 = r140.getContext();
        List r120 = CollectionsKt.mutableListOf(new com.larus.bmhome.view.screenmenu.l0[]{new com.larus.bmhome.view.screenmenu.l0(1, 2131900535, null, null, null, Integer.valueOf(v19.c.b(2130972079, r72, 2131103136)), null, Integer.valueOf(v19.c.b(2130971909, r72, 2131242410)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127), new com.larus.bmhome.view.screenmenu.l0(2, 2131908357, null, null, null, Integer.valueOf(v19.c.b(2130972079, r72, 2131103136)), null, Integer.valueOf(v19.c.b(2130971908, r72, 2131242407)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127)});
        r120.add(new com.larus.bmhome.view.screenmenu.l0(3, 2131905683, null, null, null, Integer.valueOf(v19.c.b(2130972079, r72, 2131103136)), null, Integer.valueOf(v19.c.b(2130971910, r72, 2131242414)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        if (r69 == true) goto L214;
    L216:
        Intrinsics.checkNotNull(r72);
        com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r140, CreateMenu.f(new CreateMenu(r72), r120, i5.E(), false, null, null, null, null, new x0(r119, r57, r70, r71, r140), 508), false, null, null, null, null, 120).v(r140, 0, i5.J());
        LruCache<String, wc9.e> r73 = ko8.a.a;
        y r74 = r119.u0();
        if (r74 == null) goto L219;
        String r75 = r74.Y1();
    L220:
        y r76 = r119.u0();
        if (r76 == null) goto L225;
        BotModel r77 = r76.j0();
        if (r77 == null) goto L225;
        String r78 = r77.getBotId();
    L226:
        y r79 = r119.u0();
        if (r79 == null) goto L231;
        wc9.e r80 = r79.h();
        if (r80 == null) goto L231;
        String r81 = ic8.n.f(r80);
    L232:
        de8.c r82 = s1a.d.a(r119).a(de8.c.class);
        if (r82 == null) goto L235;
        String r83 = r82.p();
    L236:
        IAIChatControlTraceService.a.Bb(r75, r78, "plus_panel", r81, r83, null, null, null);
        return;
    L235:
        r83 = null;
    L231:
        r81 = null;
    L225:
        r78 = null;
        goto L226
    L219:
        r75 = null;
        goto L220
    L214:
        if (FlowDriveSdkService.a.h() == false) goto L216;
        r120.add(new com.larus.bmhome.view.screenmenu.l0(4, 2131905374, null, null, null, 2131103136, null, 2131242413, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
    L208:
        if (FlowDriveSdkService.a.h() == false) goto L210;
        r69 = true;
        goto L211
    L192:
        ImFileUtil.a.getClass();
        r62 = ImFileUtil.l();
        goto L194
    L276:
        return;
    L260:
        return;
    L259:
        return;
    }
}
