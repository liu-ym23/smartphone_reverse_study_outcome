package com.obric.assistant.omnidetailpage.componment;

import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.gallery.api.GalleryBuilder;
import com.larus.gallery.api.ProviderType;
import com.larus.home.impl.sdk.n1;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.block.UploadLarkDoc;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.FlowDriveSdkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OmniDetailContentComponent$initViews$1$2$5 extends FunctionReferenceImpl implements Function3<ifa.a, View, Integer, Unit> {
    public OmniDetailContentComponent$initViews$1$2$5(Object r8) {
        super(3, r8, OmniDetailContentComponent.class, "handleHeaderAttachmentClick", "handleHeaderAttachmentClick(Lcom/obric/assistant/omnidetailpage/model/HeaderAttachment;Landroid/view/View;I)V", 0);
    }

    public final void invoke(ifa.a r23, final View r24, int r25) {
        Intrinsics.checkNotNullParameter(r23, "p0");
        Intrinsics.checkNotNullParameter(r24, "p1");
        final OmniDetailContentComponent r1 = (OmniDetailContentComponent) ((CallableReference) this).receiver;
        if (r25 == 103) goto L5;
        int r0 = OmniDetailContentComponent.I;
        r1.getClass();
        return;
    L5:
        List<ifa.a> r2 = r1.y;
        Iterator<T> r4 = r2.iterator();
    L6:
        FragmentManager r6 = null;
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((ifa.a) r5).a, r23.a) == false) goto L6;
    L12:
        final ifa.a r7 = (ifa.a) r5;
        if (r7 == null) goto L159;
        boolean r9 = false;
        ItemStatus r3 = com.larus.bmhome.chat.c.a(r7.c, Mode.SHOW, 0, 0, 62).getStatus();
        if (r3 == ItemStatus.UPLINK_SUCCESS) goto L21;
        if (r3 == ItemStatus.SUCCESS) goto L21;
        return;
    L21:
        if (r7.b.getLarkDoc() == null) goto L33;
        UploadLarkDoc r8 = r7.b.getLarkDoc();
        if (r8 != null) goto L25;
        OmniDetailContentComponent.c4(r24, r7, "lark doc is missing");
        return;
    L25:
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L30;
        r10.N();
        if (n1.a.y(r24.getContext(), r8.getToken(), FlowDriveSdkService.a.g(r8.getType(), r8.getTitle()), r8.getUrl(), "click_attachment_in_omni_detail") != true) goto L30;
        r9 = true;
    L30:
        if (r9 == true) goto L153;
        OmniDetailContentComponent.c4(r24, r7, "open lark doc failed");
        return;
    L153:
        return;
    L33:
        if (yc9.n1.d(r7.c) == false) goto L108;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r2.iterator();
    L36:
        if (r12.hasNext() == false) goto L90;
        ifa.a r13 = (ifa.a) r12.next();
        if (yc9.n1.d(r13.c) == false) goto L66;
        Image r14 = l1.c(r13.c);
        String r15 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.sequenceOf(new String[]{r13.d, l1.d(r13.c)}), new j()));
        if (r14 == null) goto L49;
        ImageObj r16 = r14.previewImage;
        if (r16 == null) goto L49;
        String r17 = r16.url;
        if (r17 == null) goto L49;
        if ((!StringsKt.isBlank(r17)) == false) goto L49;
    L50:
        if (r14 == null) goto L58;
        ImageObj r18 = r14.imageOri;
        if (r18 == null) goto L58;
        String r19 = r18.url;
        if (r19 == null) goto L58;
        if ((!StringsKt.isBlank(r19)) == false) goto L58;
    L59:
        if (r15 == null) goto L64;
        String r110 = Uri.fromFile(new PolarisFileWrapper(r15)).toString();
        if (r110 == null) goto L64;
        String r111 = r110;
    L69:
        String r20 = r13.a;
        if (r15 != null) goto L76;
        if (r19 != null) goto L75;
        if (r17 != null) goto L74;
        String r112 = r111;
    L77:
        if (r14 == null) goto L81;
        ImageObj r113 = r14.imageOri;
        if (r113 == null) goto L81;
        Integer r21 = Integer.valueOf(r113.width);
    L82:
        if (r14 == null) goto L86;
        ImageObj r114 = r14.imageOri;
        if (r114 == null) goto L86;
        Integer r22 = Integer.valueOf(r114.height);
    L87:
        ifa.c.a r115 = new ifa.c.a(r20, "-1", r112, r111, r21, r22);
    L88:
        if (r115 == null) goto L36;
        r11.add(r115);
    L86:
        r22 = null;
    L81:
        r21 = null;
        goto L82
    L74:
        r112 = r17;
        goto L77
    L75:
        r112 = r19;
        goto L77
    L76:
        r112 = r15;
    L64:
        if (r17 != null) goto L68;
        if (r19 == null) goto L66;
        r111 = r19;
        goto L69
    L68:
        r111 = r17;
    L58:
        r19 = null;
    L49:
        r17 = null;
    L66:
        r115 = null;
        goto L88
    L90:
        Iterator r26 = r11.iterator();
        int r27 = 0;
    L92:
        if (r26.hasNext() == false) goto L97;
        if (Intrinsics.areEqual(((ifa.c.a) r26.next()).a, r7.a) == true) goto L98;
        r27 = r27 + 1;
    L98:
        if (r27 < 0) goto L161;
        GalleryBuilder r28 = new GalleryBuilder(r24.getContext());
        com.obric.assistant.omnidetailpage.localmedia.c r29 = new com.obric.assistant.omnidetailpage.localmedia.c(r11, null, 0);
        Intrinsics.checkNotNullParameter(r29, "dataSource");
        r28.b = r29;
        com.larus.gallery.api.b r30 = OmniDetailContentComponent.E3(r24);
        Intrinsics.checkNotNullParameter(r30, "displayConfig");
        r28.d = r30;
        r28.a(ProviderType.TOP, new com.obric.assistant.omnidetailpage.localmedia.k());
        r28.a(ProviderType.BOTTOM, new com.obric.assistant.omnidetailpage.localmedia.b());
        r28.a(ProviderType.RIGHT_SIDE, new com.obric.assistant.omnidetailpage.localmedia.h());
        if (r27 < 0) goto L103;
        r28.c = r27;
    L103:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r31 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
        if (r31 == null) goto L106;
        r6 = r31.getParentFragmentManager();
    L106:
        r28.b(r6);
        return;
    L161:
        return;
    L97:
        r27 = -1;
        goto L98
    L108:
        if (yc9.n1.e(r7.c) == false) goto L111;
        r1.Z3(r7, r24, new q(r7, r24, r1));
        return;
    L111:
        if (yc9.n1.a(r7.c) == false) goto L136;
        String r32 = r7.b.getIdentifier();
        if (r32 != null) goto L115;
    L117:
        String r33 = null;
    L118:
        UplinkEntityContent r34 = r7.c.getUplinkEntityContent();
        if (r34 == null) goto L121;
        UplinkFileInfo r35 = r34.getUplinkFileInfo();
    L122:
        ifa.e r36 = r1.V3();
        if (r36 == null) goto L129;
        String r37 = r36.e;
        if (r37 == null) goto L129;
        if ((!StringsKt.isBlank(r37)) == false) goto L129;
        String r38 = r37;
    L130:
        if (r33 == null) goto L135;
        if (r35 == null) goto L135;
        if (r38 == null) goto L135;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r1), null, null, new OmniDetailContentComponent$openHeaderAudio$1(r1, r38, r24, r7, r33, r35, null), 3, null);
        return;
    L135:
        OmniDetailContentComponent.c4(r24, r7, "audio context is incomplete");
        return;
    L129:
        r38 = null;
        goto L130
    L121:
        r35 = null;
        goto L122
    L115:
        if ((!StringsKt.isBlank(r32)) == false) goto L117;
        r33 = r32;
        goto L118
    L136:
        final String r39 = l1.a(r7.c);
        if (r39 != null) goto L139;
        r39 = "";
    L139:
        r1.Z3(r7, r24, new o(r24, r39));
        return;
    L159:
        return;
    L11:
        r5 = null;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((ifa.a) r1, (View) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }
}
