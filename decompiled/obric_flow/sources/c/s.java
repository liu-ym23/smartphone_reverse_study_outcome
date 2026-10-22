package c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import cn.nubia.neopush.commons.Constant;
import com.google.gson.Gson;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.zte.miboard.cards.AppCallbackUtils;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.common.MiddleJumpAty;
import com.zte.miboard.cards.express.ExpressCard;
import com.zte.miboard.cards.express.data.ExpressNode;
import com.zte.miboard.cards.express.data.GetSFH5Request;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f1081a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1082b;

    static {
        f1081a = new ArrayList();
        f1082b = false;
        new ArrayList();
    }

    public static String a(String r10, ExpressNode r11) {
        String r5 = "";
        if (TextUtils.isEmpty(r11.getMailNo()) == true) goto L5;
        String r12 = r11.getMailNo();
    L7:
        if (TextUtils.isEmpty(r11.getExpressCode()) == true) goto L9;
        String r13 = r11.getExpressCode();
    L11:
        if (TextUtils.isEmpty(r11.getOrderNo()) == true) goto L13;
        String r14 = r11.getOrderNo();
    L15:
        if (TextUtils.isEmpty(r11.getSecretKey()) == true) goto L18;
        r5 = r11.getSecretKey();
    L18:
        if (TextUtils.isEmpty(r12) == false) goto L20;
    L21:
        StringBuilder r15 = androidx.constraintlayout.motion.widget.a.y("replaceKey info error 1=", r12, " 2=", r13, " 3=");
        r15.append(r14);
        m.n("ExpressUtils", r15.toString());
    L23:
        return r10.replaceAll("__MAIL_NO__", r12).replaceAll("__CP_CODE__", r13).replaceAll("__ORDER_CODE__", r14).replaceAll("__SECRET_KEY__", r5);
    L20:
        if (TextUtils.isEmpty(r13) == false) goto L23;
    L13:
        r14 = "";
        goto L15
    L9:
        r13 = "";
        goto L11
    L5:
        r12 = "";
        goto L7
    }

    public static List b(Context r5) {
        ArrayList r10 = new ArrayList();
        String r11 = r5.getSharedPreferences("express_info", 0).getString("express_data", null);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return (List) new Gson().fromJson(r11, new q().getType());
    }

    public static ArrayList c(Context r5) {
        ArrayList r10 = new ArrayList();
        Iterator r11 = b(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        String r12 = (String) r11.next();
        if (r12.length() == 11) goto L7;
        if (r12.length() != 10) goto L4;
        r12 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST.concat(r12);
    L7:
        r10.add(r12);
        goto L4
    L11:
        return r10;
    }

    public static HashMap d() {
        long r5 = System.currentTimeMillis() / 1000;
        String r10 = androidx.constraintlayout.motion.widget.a.j(r5, "e639f7f5158d49318b13bc528d28b01e\n020E51B2-1F58-461A-995C-41CF3FF1212C\n");
        SecretKeySpec r11 = new SecretKeySpec("020E51B2-1F58-461A-995C-41CF3FF1212C".getBytes("UTF-8"), "HmacSHA1");     // Catch: Throwable -> L5
        Mac r12 = Mac.getInstance("HmacSHA1");     // Catch: Throwable -> L5
        r12.init(r11);     // Catch: Throwable -> L5
        String r13 = Base64.getEncoder().encodeToString(r12.doFinal(r10.getBytes("UTF-8")));     // Catch: Throwable -> L5
    L7:
        if (TextUtils.isEmpty(r13) == false) goto L10;
        r13 = "";
    L10:
        HashMap r14 = new HashMap();
        r14.put("Content-Type", "application/json");
        r14.put(Constant.APPID, "e639f7f5158d49318b13bc528d28b01e");
        r14.put("appSecret", "020E51B2-1F58-461A-995C-41CF3FF1212C");
        r14.put("signature", r13);
        r14.put("timestamp", ai.j0.o(new StringBuilder(), r5, ""));
        return r14;
    L5:
        m.l("ExpressUtils", "signWithHmacSha1 error");
        r13 = null;
        goto L7
    }

    public static void e(boolean r5) {
        ArrayList r10 = f1081a;
        if (r5 == false) goto L5;
        r10.clear();
        return;
    L5:
        r10.removeIf(new o(0));
    }

    public static void f(Context r10, ExpressNode r11) {
        m.i("ExpressUtils", "startExpressInfoActivity");
        r r5 = null;
        if (r11.getPlatform() != 3) goto L43;
        if (s0.h(r10, "com.sf.activity") == true) goto L7;
        e(false);
        Iterator r12 = f1081a.iterator();
    L24:
        if (r12.hasNext() == false) goto L32;
        r r13 = (r) r12.next();
        if (r13 == null) goto L24;
        if (r13.f1077b.equalsIgnoreCase(r11.getMailNo()) == false) goto L24;
        if (r13.f1076a.equalsIgnoreCase(r11.getPhone()) == false) goto L24;
        r5 = r13;
        goto L24
    L32:
        if (r5 == null) goto L35;
        m.i("ExpressUtils", "jumpToSFH5 use cachedData");
        AppCallbackUtils.callAppJumpToWebView(r10, r5.f1078c);
    L84:
        ExpressCard.d();
        return;
    L35:
        if (v.b(r10) == true) goto L39;
        m.i("ExpressUtils", "jumpToSFH5 net error return");
        int r14 = R.string.net_connected_error;
    L37:
        Toast.makeText(r10, r14, 0).show();
        goto L84
    L39:
        if (f1082b == false) goto L41;
        m.i("ExpressUtils", "jumpToSFH5 sSFH5Requesting return");
        r14 = R.string.express_requesting_sf_later;
        goto L37
    L41:
        f1082b = true;
        m.i("ExpressUtils", "jumpToSFH5 getSFH5Url start");
        long r15 = System.currentTimeMillis();
        GetSFH5Request r16 = new GetSFH5Request(r11.getPhone(), r11.getMailNo());
        j0.b(m.a(r10).e(r16, d()), new p(r15, r10, r11));
        goto L84
    L7:
        if (TextUtils.isEmpty(r11.getSfAppOpenUrlPrefix()) == true) goto L9;
        String r17 = r11.getSfAppOpenUrlPrefix();
    L11:
        if (TextUtils.isEmpty(r11.getSfAppOpenUrlCanShu()) == true) goto L13;
        String r18 = r11.getSfAppOpenUrlCanShu();
    L14:
        String r19 = "";
        if (TextUtils.isEmpty(r11.getMailNo()) == true) goto L17;
        String r20 = r11.getMailNo();
    L19:
        if (TextUtils.isEmpty(r11.getPhone()) == true) goto L21;
        r19 = r11.getPhone();
    L21:
        String r21 = r18.replaceAll("__MAIL_NO__", r20).replaceAll("__PHONE_NO__", r19);
        StringBuilder r22 = ai.j0.u(r17);
        r22.append(URLEncoder.encode(r21));
        s0.j(r10, r22.toString());
        m.i("ExpressUtils", "startShunFengExpressInfoActivity PKG_SF");
        goto L84
    L17:
        r20 = "";
        goto L19
    L13:
        r18 = "{\"params\":{\"waybillNo\":\"__MAIL_NO__\",\"visitSource\":\"6\",\"visitlogo\":\"zte\"},\"needLogin\":\"true\",\"pageRoute\":\"ExpressDetail\",\"showBootAd\":false,\"loginAfterCoverParam\":{\"visitSource\":\"8\"}}";
        goto L14
    L9:
        r17 = "com.sf-express://sf.com?schemeParams=";
        goto L11
    L43:
        if (r11.getPlatform() != 2) goto L45;
        String r23 = r11.getMailNo();
        String r24 = r11.getOrderNo();
        Intent r25 = new Intent(r10, f.class);
        r25.addFlags(268435456);
        r25.putExtra("mailNo", r23);
        r25.putExtra("orderNo", r24);
        s0.g(r10, r25);
        goto L84
    L45:
        long r26 = System.currentTimeMillis();
        String r27 = "com.cainiao.wireless";
        if (s0.h(r10, "com.cainiao.wireless") == true) goto L48;
        String r28 = "com.taobao.taobao";
        if (s0.h(r10, "com.taobao.taobao") == true) goto L55;
        r28 = "com.eg.android.AlipayGphone";
        if (s0.h(r10, "com.eg.android.AlipayGphone") == true) goto L71;
        boolean r29 = AppCallbackUtils.showDownloadAppDialog(r10, "com.cainiao.wireless", r10.getDrawable(R.drawable.app_icon_cainiao), r10.getString(R.string.app_title_cainiao));
        m.i("ExpressUtils", "startCaiNiaoExpressInfoActivity showDownloadAppDialog jumped=" + r29);
        if (r29 == true) goto L82;
        MiddleJumpAty.b(r10, "com.cainiao.wireless", String.format(r10.getResources().getString(R.string.fast_data_download_dialog_content), new Object[]{r10.getString(R.string.app_title_cainiao)}), null, "dialog_to_store");
    L82:
        r27 = "Install_CaiNiao";
    L83:
        long r30 = System.currentTimeMillis();
        StringBuilder r31 = ai.j0.x("startCaiNiaoExpressInfoActivity to ", r27, " hao= ");
        r31.append(r30 - r26);
        r31.append("ms");
        m.i("ExpressUtils", r31.toString());
        goto L84
    L71:
        if (TextUtils.isEmpty(r11.getZhiFuBaoOpenUrlPrefix()) == true) goto L73;
        String r32 = r11.getZhiFuBaoOpenUrlPrefix();
    L75:
        if (TextUtils.isEmpty(r11.getZhiFuBaoOpenUrlCanCanShu()) == true) goto L77;
        String r33 = r11.getZhiFuBaoOpenUrlCanCanShu();
    L78:
        String r34 = a(r33, r11);
        StringBuilder r35 = ai.j0.u(r32);
    L67:
        r35.append(URLEncoder.encode(r34));
        s0.j(r10, r35.toString());
        r27 = r28;
        goto L83
    L77:
        r33 = "from=zhongxin&showcard=true&cpCode=__CP_CODE__&mailNo=__MAIL_NO__";
        goto L78
    L73:
        r32 = "alipays://platformapi/startapp?appId=2021001141626787&query=";
        goto L75
    L55:
        if (TextUtils.isEmpty(r11.getTaoBaoOpenUrlPrefix()) == true) goto L57;
        String r36 = r11.getTaoBaoOpenUrlPrefix();
    L59:
        if (TextUtils.isEmpty(r11.getTaoBaoOpenUrlH5Url()) == true) goto L61;
        String r37 = r11.getTaoBaoOpenUrlH5Url();
    L63:
        if (TextUtils.isEmpty(r11.getTaoBaoOpenUrlCanShu()) == true) goto L65;
        String r38 = r11.getTaoBaoOpenUrlCanShu();
    L66:
        String r39 = a(r38, r11);
        r35 = ai.j0.u(r36);
        StringBuilder r40 = ai.j0.u(r37);
        r40.append(URLEncoder.encode(r39));
        r40.append("&");
        r40.append(r39);
        r34 = r40.toString();
        goto L67
    L65:
        r38 = "showcard=true&mailNo=__MAIL_NO__&cpCode=__CP_CODE__&from=zhongxin";
        goto L66
    L61:
        r37 = "https://m.duanqu.com?_wml_code=vvslIPG4dzypz9NyrjCAq5IPalrXJLavIpXHcBKguXM%3D&_ariver_appid=11509317&query=";
        goto L63
    L57:
        r36 = "tbopen://m.taobao.com/tbopen/index.html?action=ali.open.nav&module=h5&h5Url=";
        goto L59
    L48:
        if (TextUtils.isEmpty(r11.getCaiNaoOpenUrl()) == true) goto L50;
        String r41 = r11.getCaiNaoOpenUrl();
    L51:
        String r42 = a(r41, r11);
        m.i("ExpressUtils", "startCaiNiaoExpressInfoActivity PKG_CAI_NIAO_GUO_GUO uri= " + r42);
        s0.j(r10, r42);
        goto L83
    L50:
        r41 = "cainiao://startapp/logistic?mailNo=__MAIL_NO__&orderCode=__ORDER_CODE__&cpCode=__CP_CODE__&from=zhongxin";
        goto L51
    }

    public static void g(Context r5) {
        if (s0.h(r5, "com.taobao.taobao") == false) goto L6;
        String r10 = "tbopen://m.taobao.com/tbopen/index.html?action=ali.open.nav&module=h5&h5Url=https%3a%2f%2fm.duanqu.com%3f_wml_code%3dvvslIPG4dzypz9NyrjCAq5IPalrXJLavIpXHcBKguXM%253D%26_ariver_appid%3d11509317%26page%3dpages%2fsearch%2fsearch%253FmailNo%253D";
    L10:
        if (TextUtils.isEmpty(r10) == true) goto L12;
        s0.j(r5, r10.concat(""));
        return;
    L12:
        boolean r11 = AppCallbackUtils.showDownloadAppDialog(r5, "com.taobao.taobao", r5.getDrawable(R.drawable.app_icon_taobao), r5.getString(R.string.app_title_taobao));
        m.i("ExpressUtils", "startExpressSearch showDownloadAppDialog jumped=" + r11);
        if (r11 == true) goto L17;
        s0.i(r5, "com.taobao.taobao");
        return;
    L17:
        return;
    L6:
        if (s0.h(r5, "com.eg.android.AlipayGphone") == false) goto L8;
        r10 = "alipays://platformapi/startapp?appId=2021001141626787&page=pages/search/search%3FmailNo%3D";
        goto L10
    L8:
        r10 = "";
        goto L10
    }
}
