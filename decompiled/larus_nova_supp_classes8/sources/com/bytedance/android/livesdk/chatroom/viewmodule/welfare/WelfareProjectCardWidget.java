package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

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
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.WelfareAppLogger;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.oy0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.WelfareProjectInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/WelfareProjectCardWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/WelfareProjectCardPresenter$IView;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WelfareProjectCardWidget extends RoomRecyclableWidget implements WelfareProjectCardPresenter.IView {
    public static final /* synthetic */ int h = 0;
    public WelfareProjectCardPresenter a;
    public IHybridComponent b;
    public FrameLayout c;
    public ImageView d;
    public Disposable e;
    public q4.b f;
    public String g;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567996;
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
        WelfareProjectCardPresenter r2 = this.a;
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
        com.bytedance.android.livesdk.log.filter.o r3 = r1.b(ju2.f.class);
        if (r3 == null) goto L9;
        r3.a(r2);
    L9:
        com.bytedance.android.livesdk.log.filter.o r4 = r1.b(iu2.a.class);
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

    public WelfareProjectCardWidget() {
    }

    public final void onInit(Object[] r2) {
        this.c = (FrameLayout) ((Widget) this).contentView.findViewById(2131393162);
        ImageView r3 = (ImageView) ((Widget) this).contentView.findViewById(2131376107);
        this.d = r3;
        r3.a(r3, s1.B(2131914422));
    }

    public final void onLoad(Object[] r9) {
        ConcurrentHashMap r10 = q4.c.a;
        Intrinsics.checkNotNullParameter("WelfareCardShow", "key");
        this.f = (q4.b) q4.c.a.remove("WelfareCardShow");
        WelfareProjectCardPresenter r11 = new WelfareProjectCardPresenter();
        this.a = r11;
        r11.g0(this);
        RoomContext r12 = getRoomContext();
        if (r12 == null) goto L9;
        com.bytedance.live.datacontext.n r13 = r12.getWelfareProjectInfo();
        if (r13 == null) goto L9;
        WelfareProjectInfo r14 = (WelfareProjectInfo) r13.getValue();
        if (r14 == null) goto L9;
        String r15 = r14.get_containerCardUrl();
    L10:
        this.g = r15;
        if (r15 != null) goto L13;
    L16:
        boolean r16 = true;
    L17:
        if (r16 == true) goto L84;
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        IHybridComponent r3 = this.b;
        r17.element = r3;
        if (r3 != null) goto L23;
        String r4 = this.g;
        if (r4 == null) goto L23;
        r17.element = jc1.k.n(IBrowserService.class).getHybridCard(((Widget) this).context, x6.a.b(r4), new x(this));
    L23:
        IHybridComponent r5 = (IHybridComponent) r17.element;
        if (r5 == null) goto L26;
        View r6 = r5.getHybridView();
    L28:
        if ((r6 instanceof WebView) == false) goto L31;
        r6.setBackgroundColor(0);
        ((WebView) r6).setVisibility(8);
    L31:
        if (r6 == null) goto L33;
        r6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L33:
        if (r6 == null) goto L35;
        ViewParent r7 = r6.getParent();
    L36:
        if (r7 == null) goto L41;
        Object r8 = r6.getParent();
        if ((r8 instanceof View) == true) goto L40;
        r8 = null;
    L40:
        r6 = (View) r8;
        goto L33
    L41:
        if (r6 == null) goto L46;
        FrameLayout r18 = this.c;
        if (r18 == null) goto L46;
        r18.addView(r6, 0);
    L46:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L61;
        TextView r19 = new TextView(((Widget) this).context);
        String r20 = "h5";
        if (SettingKeyUtils.b() == true) goto L50;
        r19.setText("h5");
    L58:
        r19.setBackgroundColor(-16711936);
        r19.setTextColor(-1);
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(-2, -2);
        r21.gravity = 8388659;
        FrameLayout r22 = this.c;
        if (r22 == null) goto L61;
        r22.addView(r19, r21);
        goto L61
    L50:
        IHybridComponent r23 = this.b;
        if (r23 == null) goto L53;
        IHybridComponent.HybridType r24 = r23.hybridType();
    L55:
        if (r24 != IHybridComponent.HybridType.LYNX) goto L57;
        r20 = "lynx";
    L57:
        r19.setText(r20);
        goto L58
    L53:
        r24 = null;
    L61:
        View r25 = new View(getContext());
        r25.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout r26 = this.c;
        if (r26 == null) goto L64;
        r26.addView(r25);
    L64:
        FrameLayout r27 = this.c;
        if (r27 == null) goto L67;
        r27.setFocusable(true);
    L67:
        FrameLayout r28 = this.c;
        if (r28 == null) goto L70;
        r28.setFocusableInTouchMode(true);
    L70:
        r25.setBackground(new ColorDrawable(0));
        r3.a(this.c, "公益卡片");
        if (SettingKeyUtils.b() == false) goto L75;
        this.b = (IHybridComponent) r17.element;
    L75:
        if (SettingKeyUtils.b() == false) goto L80;
        IHybridComponent r29 = this.b;
        if (r29 == null) goto L80;
        a7.a.a(r29, this.g, null, 2);
    L80:
        Disposable r30 = this.e;
        if (r30 == null) goto L83;
        r30.dispose();
    L83:
        this.e = Observable.timer(oy0.a.getValue().intValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new y(this));
        goto L84
    L35:
        r7 = null;
        goto L36
    L26:
        r6 = null;
    L84:
        ImageView r31 = this.d;
        if (r31 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r31);
    L87:
        ImageView r32 = this.d;
        if (r32 == null) goto L90;
        r32.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L90:
        RoomContext r33 = getRoomContext();
        if (r33 == null) goto L97;
        com.bytedance.live.datacontext.n r34 = r33.getWelfareProjectInfo();
        if (r34 == null) goto L97;
        WelfareProjectInfo r35 = (WelfareProjectInfo) r34.getValue();
        if (r35 == null) goto L97;
        long r0 = r35.getProjectId();
    L98:
        WelfareAppLogger.k(r0);
        return;
    L97:
        r0 = 0;
        goto L98
    L13:
        if (r15.length() == 0) goto L16;
        r16 = false;
    L9:
        r15 = null;
        goto L10
    }
}
