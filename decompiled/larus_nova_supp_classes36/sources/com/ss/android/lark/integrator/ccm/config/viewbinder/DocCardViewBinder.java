package com.ss.android.lark.integrator.ccm.config.viewbinder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.doc.v1.UpdateDocPermissionRequest;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.doc.entity.DocCard;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.ss.android.lark.doc.entity.DocPermission;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.doc.entity.Extra;
import com.ss.android.lark.doc.entity.ThumbnailDetail;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import dwa.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DocCardViewBinder implements ibb.c {
    public static int b = -1;
    public final Context a;

    public static class DocCardViewHolder {
        public final View a;

        @BindView(11068)
        public TextView askOwnerTv;

        @BindView(12032)
        public View askOwnerView;

        @BindView(12034)
        public ImageView orangeTipsIV;

        @BindView(12037)
        public View permStatusContainer;

        @BindView(12036)
        public TextView permStatusView;

        @BindView(12038)
        public TextView permTypeTv;

        @BindView(12033)
        public View pointIv;

        @BindView(12042)
        public ViewGroup previewThumbContainer;

        @BindView(12035)
        public TextView shareInfoView;

        @BindView(12041)
        public ImageView thumbImageView;

        @BindView(12039)
        public ImageView thumbLoadFailView;

        public DocCardViewHolder(View r1) {
            this.a = r1;
            r1.setTag(this);
            ButterKnife.bind(this, r1);
        }
    }

    public class DocCardViewHolder_ViewBinding implements Unbinder {
        public DocCardViewHolder a;

        public final void unbind() {
            DocCardViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.previewThumbContainer = null;
            r0.thumbImageView = null;
            r0.thumbLoadFailView = null;
            r0.permStatusContainer = null;
            r0.shareInfoView = null;
            r0.permStatusView = null;
            r0.askOwnerView = null;
            r0.askOwnerTv = null;
            r0.pointIv = null;
            r0.orangeTipsIV = null;
            r0.permTypeTv = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public DocCardViewHolder_ViewBinding(DocCardViewHolder r4, View r5) {
            this.a = r4;
            r4.previewThumbContainer = (ViewGroup) Utils.findRequiredViewAsType(r5, 2131369291, "field 'previewThumbContainer'", ViewGroup.class);
            r4.thumbImageView = (ImageView) Utils.findRequiredViewAsType(r5, 2131369290, "field 'thumbImageView'", ImageView.class);
            r4.thumbLoadFailView = (ImageView) Utils.findRequiredViewAsType(r5, 2131369288, "field 'thumbLoadFailView'", ImageView.class);
            r4.permStatusContainer = Utils.findRequiredView(r5, 2131369286, "field 'permStatusContainer'");
            r4.shareInfoView = (TextView) Utils.findRequiredViewAsType(r5, 2131369284, "field 'shareInfoView'", TextView.class);
            r4.permStatusView = (TextView) Utils.findRequiredViewAsType(r5, 2131369285, "field 'permStatusView'", TextView.class);
            r4.askOwnerView = Utils.findRequiredView(r5, 2131369280, "field 'askOwnerView'");
            r4.askOwnerTv = (TextView) Utils.findRequiredViewAsType(r5, 2131363251, "field 'askOwnerTv'", TextView.class);
            r4.pointIv = Utils.findRequiredView(r5, 2131369282, "field 'pointIv'");
            r4.orangeTipsIV = (ImageView) Utils.findRequiredViewAsType(r5, 2131369283, "field 'orangeTipsIV'", ImageView.class);
            r4.permTypeTv = (TextView) Utils.findRequiredViewAsType(r5, 2131369287, "field 'permTypeTv'", TextView.class);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DocType.values().length];
            a = r0;
            r0[DocType.DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            a[DocType.SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            a[DocType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            a[DocType.MINDNOTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            a[DocType.SLIDES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            a[DocType.BITABLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            a[DocType.WIKI.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            a[DocType.DOCX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            a[DocType.DOCX_SYNCED_BLOCK.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            a[DocType.DOUBAO_CHAT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            a[DocType.UNKNOWN_DOC_TYPE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public DocCardViewBinder(Context r1) {
        this.a = r1;
    }

    public static int c(DocType r3) {
        if (r3 != null) goto L7;
        tt5.a.k("DocCardViewBinder", "doc card type unknown, reason=null_type, ccmType=-1");
        return sbb.e.e.b;
    L7:
        switch(a.a[r3.ordinal()]) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L11;
            case 10: goto L9;
            default: goto L8;
        };
    L8:
        tt5.a.k("DocCardViewBinder", "doc card type unknown, imType=" + r3.getNumber() + ", ccmType=-1");
        return sbb.e.e.b;
    L9:
        tt5.a.h("DocCardViewBinder", "doc card type mapped, imType=" + r3.getNumber() + ", ccmType=125");
        return 125;
    L11:
        return 44;
    L15:
        return 16;
    L17:
        return 8;
    L19:
        return 30;
    L21:
        return 11;
    L23:
        return 12;
    L25:
        return 3;
    L27:
        return 2;
    L14:
        return sbb.e.o.b;
    }

    public static String d(DocPermission r2) {
        tt5.a.b("DocCardViewBinder", "can Edit = " + r2.canEdit() + " can Read = " + r2.canRead());
        if (r2.canEdit() == false) goto L6;
        return UIHelper.getString(2131890665);
    L6:
        return UIHelper.getString(2131890667);
    }

    public final View b(ViewGroup r4) {
        View r0 = j.d(r4.getContext()).a(r4.getContext(), 2131560090, r4);
        DocCardViewHolder r1 = new DocCardViewHolder(r0);
        DesktopUtil.a(r4.getContext());
        zz7.a.a(r1.pointIv, 14);
        zz7.a.c(r1.shareInfoView, 14);
        zz7.a.c(r1.permStatusView, 14);
        zz7.a.a(r1.orangeTipsIV, 14);
        zz7.a.c(r1.askOwnerTv, 14);
        return r0;
    }

    public final void e(final DocCard r5, final DocPermPair.PermType r6) {
        ArrayList r0 = new ArrayList();
        r0.add(new DocPermPair(r5.getMessageId(), r5.getDocId(), r6));
        UIGetDataCallback<List<String>> r1 = new AnonymousClass3(this, r5, r6);
        if (r0.size() <= 0) goto L12;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r0.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        DocPermPair r2 = (DocPermPair) r8.next();
        r7.add(new UpdateDocPermissionRequest.Pair.Builder().message_id(r2.getMessageId()).perm(UpdateDocPermissionRequest.Permission.fromValue(r2.getPerm().getNumber())).token(r2.getDocToken()).build());
        goto L7
    L9:
        UpdateDocPermissionRequest.Builder r9 = new UpdateDocPermissionRequest.Builder().pairs(r7);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_DOC_PERMISSION, r9, r1, new h());
        return;
    }

    public final void f(DocCardViewHolder r10, final DocCard r11, final boolean r12, final String r13) {
        tt5.a.b("DocCardViewBinder", "showPermissionCouldPutText");
        List r1 = r11.getPermissions();
        DocPermission r2 = r11.getUserPermission();
        r10.askOwnerView.setVisibility(8);
        r10.pointIv.setVisibility(8);
        if (r2.canShare() == false) goto L32;
        tt5.a.b("DocCardViewBinder", "userPermission.canShare");
        r10.permStatusView.setVisibility(0);
        if (r12 == false) goto L7;
        String r3 = UIHelper.getString(2131890682);
    L9:
        if (r1.size() == 0) goto L30;
        r10.permStatusContainer.setVisibility(0);
        boolean r5 = true;
        if (r1.size() > 1) goto L14;
        r5 = false;
    L14:
        tt5.a.h("DocCardViewBinder", "canEditPerm" + r5);
        r10.permStatusView.setEnabled(r5);
        TextView r4 = r10.permStatusView;
        if (r5 == false) goto L17;
        int r7 = UIHelper.getColor(2131105548);
    L18:
        r4.setTextColor(r7);
        int r6 = UIUtils.dp2px(this.a, 10.0f);
        Drawable r8 = this.a.getDrawable(2131253687);
        r8.setTint(UIUtils.getColor(this.a, 2131105548));
        r8.setBounds(0, 0, r6, r6);
        TextView r9 = r10.permStatusView;
        if (r5 == true) goto L22;
        r8 = null;
    L22:
        r9.setCompoundDrawables(null, null, r8, null);
        DocPermission r14 = r11.getCurrentDocPerm();
        if (r12 == false) goto L28;
        tt5.a.b("DocCardViewBinder", "can Edit = " + r14.canEdit() + " can Read = " + r14.canRead());
        if (r14.canEdit() == false) goto L27;
        String r0 = UIHelper.getString(2131890666);
    L29:
        r10.permStatusView.setText(r0);
    L31:
        r10.permStatusView.setOnClickListener(new c(this, r11, r13, r12));
        r10.permTypeTv.setVisibility(8);
    L33:
        r10.shareInfoView.setText(r3);
        return;
    L27:
        r0 = UIHelper.getString(2131890668);
        goto L29
    L28:
        r0 = d(r14);
        goto L29
    L17:
        r7 = UIHelper.getColor(2131106622);
        goto L18
    L30:
        tt5.a.d("DocCardViewBinder", "docPermissions.size() == 0 !");
        r10.permStatusContainer.setVisibility(8);
        goto L31
    L7:
        r3 = r13;
        goto L9
    L32:
        r10.permStatusView.setVisibility(8);
        r3 = UIHelper.getString(2131890683);
        goto L33
    }

    public final void a(View r25, final DocResult r26, String r27, String r28, String r29, String r30, String r31, final String r32, String r33, boolean r34, final boolean r35, boolean r36, boolean r37) {
        tt5.a.b("DocCardViewBinder", "start onBindView");
        DocCardViewHolder r11 = (DocCardViewHolder) r25.getTag();
        final Doc r10 = r26.getDoc();
        if (r10 == null) goto L112;
        r11.a.setVisibility(0);
        String r0 = r10.getAbstract();
        if (TextUtils.isEmpty(r0) == true) goto L21;
        ImageView r5 = r11.thumbImageView;
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        int r7 = r5.getMeasuredWidth();
        int r16 = b;
        if (r16 <= 0) goto L9;
        r7 = r16;
    L9:
        if (r7 <= 0) goto L14;
        r6.width = r7;
        int r9 = (int) (r7 / 1.7f);
        if (r9 <= 0) goto L13;
        r6.height = r9;
        r5.setLayoutParams(r6);
    L13:
        b = r7;
    L14:
        tt5.a.b("HWC", "width:" + r6.width + "--height:" + r6.height + "--url:" + r0);
        SpacekitSdkWrapper r8 = SpacekitSdkWrapper.b.a;
        ec5.a.a r12 = new ec5.a.a();
        r12.a = this.a;
        r12.b = r0;
        r12.e = r11.thumbImageView;
        r12.c = r10.getDocType().getNumber();
        r12.d = new f(r11);
        ThumbnailDetail r1 = r10.getThumbnaimDetail();
        if (r1 != null) goto L119;
    L20:
        ec5.a r2 = new ec5.a(r12);
        r8.getClass();
        Log.i("SpacekitSdkWrapper", "DocsImpl.loadThumbnail ");
        RxScheduledExecutor.justInIO(new com.ss.android.lark.integrator.ccm.spacekit.e(r2));
    L22:
        r11.previewThumbContainer.setOnClickListener(new com.ss.android.lark.integrator.ccm.config.viewbinder.a(r10, r35, r32, r26));
        if (r37 == false) goto L25;
        r11.previewThumbContainer.setBackground(UIUtils.getDrawable(this.a, 2131233824));
        int r3 = UIUtils.dp2px(this.a, 1.0f);
        r11.previewThumbContainer.setPadding(r3, r3, r3, r3);
    L26:
        if (r35 == true) goto L28;
        String r17 = r30;
        String r18 = r28;
        String r4 = r29;
    L29:
        FragmentActivity r13 = this.a;
        String r19 = r10.getId();
        int r110 = c(r10.getDocType());
        String r20 = r10.getOwnerId();
        String r21 = r10.getOwnerName();
        if (r35 == false) goto L32;
        int r22 = 2;
    L33:
        Doc r111 = r10;
        String r14 = "DocCardViewBinder";
        final vb5.a r15 = new vb5.a(r13, r19, r110, r20, r21, r22, r34, r4, r18, r17);
        final DocType r23 = r111.getDocType();
        final DocCard r24 = r26.getDocCard();
        tt5.a.h(r14, "showDocPermStatusView & isSlef= " + r36);
        tt5.a.h(r14, "sendId=" + r27 + " p2pChatterId= " + r29);
        if (r36 == true) goto L36;
    L100:
        tt5.a.b(r14, "not sender");
        r11.permStatusContainer.setVisibility(0);
        r11.askOwnerView.setVisibility(8);
        r11.permStatusView.setVisibility(8);
        DocPermission r38 = r24.getUserPermission();
        if (r38.canEdit() == false) goto L103;
    L106:
        r11.pointIv.setVisibility(8);
        tt5.a.b(r14, "can Edit = " + r38.canEdit() + " can Read = " + r38.canRead());
        if (r38.canEdit() == false) goto L109;
        String r39 = UIHelper.getString(2131891558);
    L110:
        String r40 = UIHelper.mustacheFormat(2131890686, "permission", r39);
    L111:
        r11.shareInfoView.setText(r40);
    L113:
        if (r111 != null) goto L115;
    L117:
        tt5.a.b(r14, "end onBindView");
        return;
    L115:
        if (TextUtils.isEmpty(r111.getUrl()) == true) goto L117;
        String r41 = r111.getUrl();
        SpacekitSdkWrapper r42 = SpacekitSdkWrapper.b.a;
        List r43 = Collections.singletonList(r41);
        r42.getClass();
        SpacekitSdkWrapper.h(r43);
        goto L117
    L109:
        r39 = UIHelper.getString(2131891560);
        goto L110
    L103:
        if (r38.canRead() == true) goto L106;
        r11.pointIv.setVisibility(0);
        r40 = UIHelper.getString(2131890685);
        goto L111
    L36:
        if (TextUtils.equals(r27, r29) == true) goto L100;
        r11.permStatusView.setVisibility(0);
        long r44 = r24.getShareStatus();
        LongSparseArray r45 = xb5.a.a;
        tt5.a.h(r14, "shareStatus = " + r44);
        if (r44 > 1) goto L40;
        boolean r46 = FeatureGatingModule.getFeatureGatingService().isEnable("spacekit.mobile.external_share_tips_enable", false);
        boolean r47 = r24.getSenderIsExternal();
        Extra r112 = r24.getExtra();
        if (r112 == null) goto L81;
        boolean r113 = r112.hasReadOrEditPer();
    L82:
        tt5.a.h(r14, "senderIsExternal = " + r47 + " isCrossTenant = " + r34 + " = " + r113);
        if (r46 == false) goto L90;
        if (r113 == false) goto L90;
        if (r47 == false) goto L87;
        if (r34 == true) goto L87;
    L89:
        boolean r48 = true;
    L91:
        if (r48 == false) goto L99;
        f(r11, r24, r35, r28);
        tt5.a.b(r14, "showCancelSharedUI  isGroup = " + r35);
        r11.askOwnerView.setVisibility(0);
        r11.pointIv.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) r11.orangeTipsIV.getLayoutParams()).leftMargin = UIUtils.dp2px(this.a, 8.0f);
        ((ViewGroup.MarginLayoutParams) r11.askOwnerTv.getLayoutParams()).rightMargin = UIUtils.dp2px(this.a, 8.0f);
        LinearLayout.LayoutParams r49 = (LinearLayout.LayoutParams) r11.askOwnerView.getLayoutParams();
        r49.bottomMargin = cu5.c.b(6);
        r49.topMargin = cu5.c.b(12);
        if (r34 == false) goto L97;
        if (r35 == false) goto L96;
        int r50 = 2131892510;
    L98:
        String r51 = this.a.getString(r50);
        String r52 = r51 + this.a.getText(2131892509).toString();
        SpannableStringBuilder r53 = new SpannableStringBuilder(r52);
        r53.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2131106622)), 0, r51.length(), 33);
        r53.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2131106616)), r51.length(), r52.length(), 33);
        r11.askOwnerTv.setText(r53);
        r11.askOwnerTv.setOnClickListener(new d(this, r23, r24, r15));
        r11.askOwnerView.setVisibility(0);
        goto L113
    L96:
        r50 = 2131892512;
        goto L98
    L97:
        r50 = 2131892511;
        goto L98
    L99:
        f(r11, r24, r35, r28);
    L87:
        if (r47 == true) goto L90;
        if (r34 == true) goto L89;
    L90:
        r48 = false;
        goto L91
    L81:
        r113 = false;
        goto L82
    L40:
        if (r35 == true) goto L42;
    L47:
        boolean r54 = true;
    L49:
        if (r44 != 6) goto L51;
    L54:
        boolean r114 = true;
    L55:
        if (r114 == false) goto L66;
        if (r54 == false) goto L66;
        tt5.a.h(r14, "noSharePerm");
        if (r24.getReceiverPermission().canRead() == false) goto L60;
        tt5.a.b(r14, "showTextWithoutSharePerm");
        r11.permStatusView.setVisibility(8);
        r11.permStatusContainer.setVisibility(0);
        r11.askOwnerView.setVisibility(8);
        r11.pointIv.setVisibility(8);
        r11.shareInfoView.setText(xb5.e.a(r35, r28, d(r24.getReceiverPermission())));
        goto L113
    L60:
        tt5.a.b(r14, "showAskOwnerUI");
        r11.permStatusView.setVisibility(8);
        r11.permStatusContainer.setVisibility(8);
        r11.askOwnerView.setVisibility(0);
        r11.pointIv.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) r11.orangeTipsIV.getLayoutParams()).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) r11.askOwnerTv.getLayoutParams()).rightMargin = 0;
        LinearLayout.LayoutParams r55 = (LinearLayout.LayoutParams) r11.askOwnerView.getLayoutParams();
        r55.bottomMargin = 0;
        r55.topMargin = 0;
        Context r56 = this.a;
        if (r35 == false) goto L63;
        int r57 = 2131890663;
    L64:
        String r58 = r56.getText(r57).toString();
        String r59 = r58 + this.a.getText(2131890662).toString();
        SpannableStringBuilder r60 = new SpannableStringBuilder(r59);
        r60.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2131106622)), 0, r58.length(), 33);
        r60.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2131106616)), r58.length(), r59.length(), 33);
        r11.askOwnerTv.setText(r60);
        r11.askOwnerTv.setOnClickListener(new b(r15));
        r11.askOwnerView.setVisibility(0);
        goto L113
    L63:
        r57 = 2131890661;
    L66:
        if (r45.indexOfKey(r44) < 0) goto L68;
        int r61 = ((Integer) r45.get(r44)).intValue();
    L69:
        r11.askOwnerView.setVisibility(8);
        r11.permStatusContainer.setVisibility(0);
        String r62 = UIHelper.getString(r61);
        tt5.a.h(r14, "hasSharePerm：" + r62);
        r11.shareInfoView.setText(r62);
        r11.permStatusView.setVisibility(8);
        if (r44 >= 6) goto L72;
    L74:
        boolean r63 = false;
    L75:
        if (r63 == false) goto L77;
        r11.pointIv.setVisibility(0);
        goto L113
    L77:
        r11.pointIv.setVisibility(8);
        goto L113
    L72:
        if (r44 > 12) goto L74;
        r63 = true;
        goto L75
    L68:
        r61 = 2131890687;
        goto L69
    L51:
        if (r44 == 7) goto L54;
        r114 = false;
        goto L55
    L42:
        if (r24.getExtra() != null) goto L44;
    L46:
        r54 = false;
        goto L49
    L44:
        if (r24.getExtra().owner_in_group == false) goto L46;
    L32:
        r22 = 0;
        goto L33
    L28:
        r18 = r31;
        r17 = r33;
        r4 = r32;
        goto L29
    L25:
        r11.previewThumbContainer.setBackgroundColor(UIUtils.getColor(this.a, 2131106784));
        r11.previewThumbContainer.setPadding(0, 0, 0, 0);
        goto L26
    L119:
        r12.j = "chat";     // Catch: Exception -> L18
        r12.i = CastIntegerProtector.parseInt(r1.cipherType);     // Catch: Exception -> L18
        r12.f = r1.thumbnailUrlMobile;     // Catch: Exception -> L18
        r12.g = r1.decryptKeyMobile;     // Catch: Exception -> L18
        r12.h = r1.decryptNonceMobile;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        tt5.a.f("DocCardViewBinder", e, false);
        goto L20
    L21:
        tt5.a.d("DocCardViewBinder", "previewThumbUrl is empty");
        goto L22
    L112:
        r111 = r10;
        r14 = "DocCardViewBinder";
        r11.a.setVisibility(8);
        tt5.a.d(r14, "doc is null");
        goto L113
    }
}
