package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.WelfareAppLogger;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.oy0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.WelfareProjectInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/right/WelfareProjectBottomRightCardWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/right/WelfareProjectBottomRightCardPresenter$IView;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WelfareProjectBottomRightCardWidget extends RoomRecyclableWidget implements WelfareProjectBottomRightCardPresenter.IView {
    public static final /* synthetic */ int i = 0;
    public WelfareProjectBottomRightCardPresenter a;
    public IHybridComponent b;
    public FrameLayout c;
    public ImageView d;
    public Disposable e;
    public q4.b f;
    public String g;
    public e h;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567995;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    public final void onUnload() {
        FrameLayout r0 = this.c;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        if (SettingKeyUtils.b() == false) goto L12;
        IHybridComponent r1 = this.b;
        if (r1 == null) goto L11;
        r1.release();
    L11:
        this.b = null;
    L12:
        WelfareProjectBottomRightCardPresenter r2 = this.a;
        if (r2 == null) goto L15;
        r2.detachView();
    L15:
        this.a = null;
        Disposable r3 = this.e;
        if (r3 == null) goto L18;
        r3.dispose();
    L18:
        this.e = null;
    }

    public final JSONObject wq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.vs.f r1 = com.bytedance.android.livesdk.vs.f.a(r0);
        HashMap r2 = new HashMap();
        o r3 = r1.b(ju2.f.class);
        if (r3 == null) goto L9;
        r3.a(r2);
    L9:
        o r4 = r1.b(iu2.a.class);
        if (r4 == null) goto L12;
        r4.a(r2);
    L12:
        JSONObject r5 = new JSONObject();
        Iterator r6 = r2.entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L20;
        Map.Entry r7 = (Map.Entry) r6.next();
        r5.put((String) r7.getKey(), (String) r7.getValue());     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        ALogger.w("WelfareProjectCardWidget", "put json with err; err=" + e.getMessage());
        goto L14
    L20:
        return r5;
    L5:
        return new JSONObject();
    }

    public WelfareProjectBottomRightCardWidget() {
    }

    public final void onInit(Object[] r2) {
        this.c = (FrameLayout) ((Widget) this).contentView.findViewById(2131393162);
        ImageView r3 = (ImageView) ((Widget) this).contentView.findViewById(2131376107);
        this.d = r3;
        r3.a(r3, s1.B(2131914422));
    }

    public final void onLoad(Object[] r10) {
        ConcurrentHashMap r11 = q4.c.a;
        Intrinsics.checkNotNullParameter("WelfareCardShow", "key");
        this.f = (q4.b) q4.c.a.remove("WelfareCardShow");
        WelfareProjectBottomRightCardPresenter r12 = new WelfareProjectBottomRightCardPresenter();
        this.a = r12;
        r12.g0(this);
        RoomContext r13 = getRoomContext();
        Object r0 = null;
        if (r13 == null) goto L9;
        n r14 = r13.getWelfareProjectInfo();
        if (r14 == null) goto L9;
        WelfareProjectInfo r15 = (WelfareProjectInfo) r14.getValue();
        if (r15 == null) goto L9;
        String r16 = r15.get_containerCardUrl();
    L10:
        this.g = r16;
        if (r16 != null) goto L13;
    L84:
        ImageView r17 = this.d;
        if (r17 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r17);
    L87:
        ImageView r18 = this.d;
        if (r18 == null) goto L90;
        r18.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L90:
        DataCenter r19 = ((Widget) this).dataCenter;
        if (r19 == null) goto L97;
        Object r110 = r19.get("key_welfare_report_card_show", null);
        if ((r110 instanceof Boolean) == false) goto L96;
        r0 = r110;
    L96:
        r0 = (Boolean) r0;
    L97:
        Boolean r111 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r0, r111)) == false) goto L116;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L102;
        r1.put("key_welfare_report_card_show", r111);
    L102:
        RoomContext r112 = getRoomContext();
        if (r112 == null) goto L109;
        n r113 = r112.getWelfareProjectInfo();
        if (r113 == null) goto L109;
        WelfareProjectInfo r114 = (WelfareProjectInfo) r113.getValue();
        if (r114 == null) goto L109;
        long r2 = r114.getProjectId();
    L110:
        WelfareAppLogger.k(r2);
        return;
    L109:
        r2 = 0;
        goto L110
    L116:
        return;
    L13:
        if (r16.length() != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L84;
        UrlBuilder r4 = new UrlBuilder(WelfareAppLogger.b(r16));
        r4.addParam("welfare_card_type", "vertical");
        Ref.ObjectRef r115 = new Ref.ObjectRef();
        IHybridComponent r5 = this.b;
        r115.element = r5;
        if (r5 != null) goto L23;
        String r6 = this.g;
        if (r6 == null) goto L23;
        r115.element = k.n(IBrowserService.class).getHybridCard(((Widget) this).context, x6.a.b(r6), new h(this));
    L23:
        IHybridComponent r7 = (IHybridComponent) r115.element;
        if (r7 == null) goto L26;
        View r8 = r7.getHybridView();
    L28:
        if ((r8 instanceof WebView) == false) goto L31;
        r8.setBackgroundColor(0);
        ((WebView) r8).setVisibility(8);
    L31:
        if (r8 == null) goto L33;
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L33:
        if (r8 == null) goto L35;
        ViewParent r9 = r8.getParent();
    L36:
        if (r9 == null) goto L41;
        Object r20 = r8.getParent();
        if ((r20 instanceof View) == true) goto L40;
        r20 = null;
    L40:
        r8 = (View) r20;
        goto L33
    L41:
        if (r8 == null) goto L46;
        FrameLayout r21 = this.c;
        if (r21 == null) goto L46;
        r21.addView(r8, 0);
    L46:
        if (v.a() == false) goto L61;
        TextView r22 = new TextView(((Widget) this).context);
        String r23 = "h5";
        if (SettingKeyUtils.b() == true) goto L50;
        r22.setText("h5");
    L58:
        r22.setBackgroundColor(-16711936);
        r22.setTextColor(-1);
        FrameLayout.LayoutParams r24 = new FrameLayout.LayoutParams(-2, -2);
        r24.gravity = 8388659;
        FrameLayout r25 = this.c;
        if (r25 == null) goto L61;
        r25.addView(r22, r24);
        goto L61
    L50:
        IHybridComponent r26 = this.b;
        if (r26 == null) goto L53;
        IHybridComponent.HybridType r27 = r26.hybridType();
    L55:
        if (r27 != IHybridComponent.HybridType.LYNX) goto L57;
        r23 = "lynx";
    L57:
        r22.setText(r23);
        goto L58
    L53:
        r27 = null;
    L61:
        View r28 = new View(getContext());
        r28.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout r29 = this.c;
        if (r29 == null) goto L64;
        r29.addView(r28);
    L64:
        FrameLayout r30 = this.c;
        if (r30 == null) goto L67;
        r30.setFocusable(true);
    L67:
        FrameLayout r31 = this.c;
        if (r31 == null) goto L70;
        r31.setFocusableInTouchMode(true);
    L70:
        r28.setBackground(new ColorDrawable(0));
        r3.a(this.c, "公益卡片");
        if (SettingKeyUtils.b() == false) goto L75;
        this.b = (IHybridComponent) r115.element;
    L75:
        if (SettingKeyUtils.b() == false) goto L80;
        IHybridComponent r116 = this.b;
        if (r116 == null) goto L80;
        a7.a.a(r116, r4.build(), null, 2);
    L80:
        Disposable r117 = this.e;
        if (r117 == null) goto L83;
        r117.dispose();
    L83:
        this.e = Observable.timer(oy0.a.getValue().intValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this));
        goto L84
    L35:
        r9 = null;
        goto L36
    L26:
        r8 = null;
        goto L28
    L15:
        r3 = false;
    L9:
        r16 = null;
        goto L10
    }
}
