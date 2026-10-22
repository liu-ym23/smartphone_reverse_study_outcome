package com.bytedance.android.ec.common.api;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import cf.p;
import cf.t;
import cf.u;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.ec.model.e;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.model.sku.SkuCheckResult;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.livesdk.livecommerce.iron.helper.d;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mf.b;
import ul.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0094\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\u001c\b\u0002\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H&Jj\u00100\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020 2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010H&J\u009a\u0003\u0010X\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%2\u0006\u00101\u001a\u00020 2\b\b\u0002\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\u00112\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u00112\u0006\u0010=\u001a\u00020<2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010@\u001a\u00020<2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010C\u001a\u00020<2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010E\u001a\u00020<2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010H\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010J\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N2\u0018\b\u0002\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010P2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00112%\b\u0002\u0010W\u001a\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(V\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016H&¢\u0006\u0004\bX\u0010YJ}\u0010g\u001a\u00020\u00142\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020Z2\u0006\u0010]\u001a\u00020\u00042\b\u0010^\u001a\u0004\u0018\u00010 2\b\u0010_\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010Z2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d2\u0010\b\u0002\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010H&¢\u0006\u0004\bg\u0010hJ\u0087\u0001\u0010g\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%2\b\b\u0001\u0010j\u001a\u00020i2\b\b\u0001\u0010k\u001a\u00020i2\u0006\u0010]\u001a\u00020\u00042\b\u0010`\u001a\u0004\u0018\u00010Z2\b\u0010b\u001a\u0004\u0018\u00010a2\b\u0010c\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010<2\u0010\b\u0002\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010H&¢\u0006\u0004\bg\u0010lJ\u0016\u0010m\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010PH&J,\u0010s\u001a\u0004\u0018\u00010r2\u000e\u0010p\u001a\n\u0012\u0006\b\u0001\u0012\u00020o0n2\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010\u0010H&J2\u0010w\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010t\u001a\u00020\u00112\u0006\u0010u\u001a\u00020\u00042\b\u0010v\u001a\u0004\u0018\u00010\u0011H&J2\u0010~\u001a\u00020\u00142\u0006\u0010x\u001a\u00020\u00112\u0006\u0010z\u001a\u00020y2\u0006\u0010{\u001a\u00020\u00112\u0006\u0010|\u001a\u00020\u00112\b\b\u0002\u0010}\u001a\u00020<H&J!\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00012\b\u0010\u007f\u001a\u0004\u0018\u00010\u00112\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0011H&J\u001d\u0010\u0087\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00112\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001H&J\u001e\u0010\u0087\u0001\u001a\u00030\u0086\u00012\b\u0010\u0089\u0001\u001a\u00030\u0088\u00012\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001H&¨\u0006\u008a\u0001"}, d2 = {"Lcom/bytedance/android/ec/common/api/IECCommonService;", "", "Lcom/bytedance/android/ec/model/response/ECPromotionCampaign;", "campaign", "", "serverTime", "Lcom/bytedance/android/ec/model/promotion/ECUICampaign;", "convertCampaign", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bytedance/android/ec/model/sku/SkuParams;", "skuParams", "Lcf/t;", "skuLiveService", "Lcom/bytedance/android/btm/api/model/l;", "btmModel", "Lkotlin/Function0;", "", "promotionListEntranceInfo", "Lkotlin/Function2;", "", "adLogCallBack", "Lkotlin/Function1;", "finishPlaybackPageListener", "Lcom/bytedance/android/ec/model/sku/SkuShowAndDismissState;", "showAndDismissListener", "Lcom/bytedance/android/ec/model/sku/SkuProductDetailInfo;", "refreshDetailInfoCallback", "Lcom/bytedance/android/ec/model/sku/SkuCartResult;", "cartListener", "Lcom/bytedance/android/ec/model/sku/SkuCheckResult;", "skuCheckResultCallback", "", "ultimateBuyType", "Lul/i;", "skuSchema", "addCartSuccessListener", "Landroid/content/Context;", "context", "Lcf/u;", "showSkuPanel", "Lcom/bytedance/android/ec/model/promotion/ECResultDialogContentVO;", "content", "type", "showDialogCallback", "dismissDialogCallback", "cancelBtnCallback", "confirmBtnCallback", "showResultDialog", "sceneType", "addToastType", "originType", "originId", "promotionId", "productId", "authorId", "secAuthorId", BdpAwemeConstant.KEY_ROOM_ID, "shopId", "trackExtra", "", "isGroupBuying", "receiveAddressId", "marketChannel", "needShowAddCartMotion", "addCartEntranceInfo", "comboId", "isHourArrivedRoom", "btmPageId", "useNewAddApi", "skuSessionId", "channelId", "channelType", "authorOpenId", "comboNum", "bizCampaignType", "Lcom/bytedance/android/ec/model/e;", "extraParams", "Lcf/a;", "customAddCartListener", "", "trackMeta", "foodTakeoutCustomPropertyList", "foodTakeoutSalePackageList", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "count", "addCartListener", "addCartDirectly", "(Landroid/content/Context;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/bytedance/android/btm/api/model/l;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/e;Lcf/a;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Landroid/view/View;", "sourceView", "destinationView", "delay", "windowsPriority", "isDeleteStatusHeight", "animLayout", "", "animLayoutWidth", "animLayoutHeight", "Landroid/animation/AnimatorSet;", "customAnimator", "callback", "addCartMotion", "(Landroid/view/View;Landroid/view/View;JLjava/lang/Integer;Ljava/lang/Boolean;Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Landroid/animation/AnimatorSet;Lkotlin/jvm/functions/Function0;)V", "", "sourceLocation", "destinationLocation", "(Landroid/content/Context;[F[FJLandroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Landroid/animation/AnimatorSet;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "getExplainReplayCommonParams", "Ljava/lang/Class;", "Lmf/b;", "clazz", "newInstance", "Lmf/a;", "getOpenOrderSchemaHelper", "selectSkuId", "buyNum", "sourceBtmToken", "buyNowDirectly", "orderUrl", "Landroid/app/Activity;", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "packLogId", "skuLogId", "isInSplit", "openBuyNowSchemaWidthRouterHelper", "listenerId", "listenerExtra", "Lcf/p;", "createPageStateListenerHelper", com.bytedance.android.ec.core.event.a.KEY_URL, "Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;", "entranceInfoScene", "Lcom/bytedance/android/ec/model/order/IOrderSchema;", "convertToOrderSchema", "Landroid/net/Uri;", "uri", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IECCommonService {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(IECCommonService r12, View r13, View r14, Integer r15, Boolean r16, Function0 r17, int r18) {
            if ((r18 & 512) == 0) goto L5;
            Function0 r11 = null;
        L6:
            r12.addCartMotion(r13, r14, 50, r15, r16, null, null, null, null, r11);
            return;
        L5:
            r11 = r17;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(IECCommonService r10, Context r11, ECResultDialogContentVO r12, Function0 r13, Function0 r14, Function0 r15, int r16) {
            if ((r16 & 8) == 0) goto L5;
            Function0 r17 = null;
        L7:
            if ((r16 & 32) == 0) goto L9;
            Function0 r18 = null;
        L11:
            if ((r16 & 64) == 0) goto L13;
            Function0 r19 = null;
        L14:
            r10.showResultDialog(r11, r12, 0, r17, null, r18, r19);
            return;
        L13:
            r19 = r15;
            goto L14
        L9:
            r18 = r14;
            goto L11
        L5:
            r17 = r13;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ u d(IECCommonService r19, FragmentManager r20, SkuParams r21, d r22, l r23, Function0 r24, Function2 r25, Function1 r26, Function1 r27, Function1 r28, Function1 r29, Function1 r30, int r31, SkuSchemaParams r32, Function0 r33, Context r34, int r35) {
            if ((r35 & 4) == 0) goto L5;
            d r10 = null;
        L7:
            if ((r35 & 8) == 0) goto L9;
            l r11 = null;
        L11:
            if ((r35 & 16) == 0) goto L13;
            Function0 r12 = null;
        L15:
            if ((r35 & 32) == 0) goto L17;
            Function2 r13 = null;
        L19:
            if ((r35 & 64) == 0) goto L21;
            Function1 r14 = null;
        L23:
            if ((r35 & 256) == 0) goto L25;
            Function1 r15 = null;
        L27:
            if ((r35 & 512) == 0) goto L29;
            Function1 r16 = null;
        L31:
            if ((r35 & 1024) == 0) goto L33;
            Function1 r17 = null;
        L35:
            if ((r35 & 2048) == 0) goto L37;
            int r18 = 0;
        L39:
            if ((r35 & 4096) == 0) goto L41;
            SkuSchemaParams r110 = null;
        L43:
            if ((r35 & 8192) == 0) goto L45;
            Function0 r111 = null;
        L47:
            if ((r35 & 16384) == 0) goto L49;
            Context r112 = null;
        L51:
            return r19.showSkuPanel(r20, r21, r10, r11, r12, r13, r14, r27, r15, r16, r17, r18, r110, r111, r112);
        L49:
            r112 = r34;
            goto L51
        L45:
            r111 = r33;
            goto L47
        L41:
            r110 = r32;
            goto L43
        L37:
            r18 = r31;
            goto L39
        L33:
            r17 = r30;
            goto L35
        L29:
            r16 = r29;
            goto L31
        L25:
            r15 = r28;
            goto L27
        L21:
            r14 = r26;
            goto L23
        L17:
            r13 = r25;
            goto L19
        L13:
            r12 = r24;
            goto L15
        L9:
            r11 = r23;
            goto L11
        L5:
            r10 = r22;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IECCommonService r38, Context r39, int r40, int r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, boolean r51, String r52, String r53, boolean r54, String r55, String r56, l r57, boolean r58, String r59, String r60, Integer r61, String r62, String r63, e r64, cf.a r65, Map r66, String r67, String r68, Function1 r69, int r70, int r71) {
            if ((r70 & 4) == 0) goto L5;
            int r10 = 0;
        L7:
            if ((r70 & 8192) == 0) goto L9;
            String r17 = null;
        L11:
            if ((r70 & 16384) == 0) goto L13;
            String r18 = null;
        L15:
            if ((32768 & r70) == 0) goto L17;
            boolean r19 = false;
        L19:
            if ((131072 & r70) == 0) goto L21;
            String r21 = null;
        L23:
            if ((524288 & r70) == 0) goto L25;
            String r23 = null;
        L27:
            if ((1048576 & r70) == 0) goto L29;
            l r24 = null;
        L31:
            if ((2097152 & r70) == 0) goto L33;
            boolean r25 = false;
        L35:
            if ((4194304 & r70) == 0) goto L37;
            String r26 = null;
        L39:
            if ((8388608 & r70) == 0) goto L41;
            String r27 = null;
        L43:
            if ((16777216 & r70) == 0) goto L45;
            Integer r28 = 0;
        L47:
            if ((33554432 & r70) == 0) goto L49;
            String r29 = null;
        L51:
            if ((134217728 & r70) == 0) goto L53;
            String r31 = null;
        L55:
            if ((268435456 & r70) == 0) goto L57;
            e r32 = null;
        L59:
            if ((536870912 & r70) == 0) goto L61;
            cf.a r33 = null;
        L63:
            if ((1073741824 & r70) == 0) goto L65;
            Map r34 = null;
        L67:
            if ((r70 & Integer.MIN_VALUE) == 0) goto L69;
            String r35 = null;
        L71:
            if ((r71 & 1) == 0) goto L73;
            String r36 = null;
        L75:
            if ((r71 & 2) == 0) goto L77;
            Function1 r37 = null;
        L78:
            r38.addCartDirectly(r39, r40, r10, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r17, r18, r19, null, r21, false, r23, r24, r25, r26, r27, r28, r29, null, r31, r32, r33, r34, r35, r36, r37);
            return;
        L77:
            r37 = r69;
            goto L78
        L73:
            r36 = r68;
            goto L75
        L69:
            r35 = r67;
            goto L71
        L65:
            r34 = r66;
            goto L67
        L61:
            r33 = r65;
            goto L63
        L57:
            r32 = r64;
            goto L59
        L53:
            r31 = r63;
            goto L55
        L49:
            r29 = r62;
            goto L51
        L45:
            r28 = r61;
            goto L47
        L41:
            r27 = r60;
            goto L43
        L37:
            r26 = r59;
            goto L39
        L33:
            r25 = r58;
            goto L35
        L29:
            r24 = r57;
            goto L31
        L25:
            r23 = r56;
            goto L27
        L21:
            r21 = r55;
            goto L23
        L17:
            r19 = r54;
            goto L19
        L13:
            r18 = r53;
            goto L15
        L9:
            r17 = r52;
            goto L11
        L5:
            r10 = r41;
            goto L7
        }
    }

    void addCartDirectly(Context r1, int r10, int r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, boolean r111, String r112, String r113, boolean r114, String r115, String r116, boolean r117, String r20, l r21, boolean r22, String r23, String r24, Integer r25, String r26, Integer r27, String r28, e r29, cf.a r30, Map<String, ? extends Object> r31, String r32, String r33, Function1<? super Integer, Unit> r34);

    void addCartMotion(Context r1, float[] r10, float[] r11, long r12, View r13, Float r14, Float r15, Integer r16, AnimatorSet r17, Boolean r18, Function0<Unit> r19);

    void addCartMotion(View r1, View r10, long r11, Integer r12, Boolean r13, View r14, Float r15, Float r16, AnimatorSet r17, Function0<Unit> r18);

    void buyNowDirectly(Context r1, SkuParams r10, String r11, long r12, String r13);

    ECUICampaign convertCampaign(ECPromotionCampaign r1, long r10);

    IOrderSchema convertToOrderSchema(Uri r1, EntranceInfoScene r10);

    IOrderSchema convertToOrderSchema(String r1, EntranceInfoScene r10);

    p createPageStateListenerHelper(String r1, String r10);

    Map<String, String> getExplainReplayCommonParams();

    mf.a getOpenOrderSchemaHelper(Class<? extends b> r1, Function0<? extends b> r10);

    void openBuyNowSchemaWidthRouterHelper(String r1, Activity r10, String r11, String r12, boolean r13);

    void showResultDialog(Context r1, ECResultDialogContentVO r10, int r11, Function0<Unit> r12, Function0<Unit> r13, Function0<Unit> r14, Function0<Unit> r15);

    u showSkuPanel(FragmentManager r1, SkuParams r10, t r11, l r12, Function0<String> r13, Function2<? super SkuParams, ? super Long, Unit> r14, Function1<? super String, Unit> r15, Function1<? super SkuShowAndDismissState, Unit> r16, Function1<? super SkuProductDetailInfo, Unit> r17, Function1<? super SkuCartResult, Unit> r18, Function1<? super SkuCheckResult, Unit> r19, int r110, i r111, Function0<Unit> r112, Context r113);
}
