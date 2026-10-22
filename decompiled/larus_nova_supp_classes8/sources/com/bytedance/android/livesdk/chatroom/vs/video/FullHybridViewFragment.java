package com.bytedance.android.livesdk.chatroom.vs.video;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.livesdk.chatroom.ui.AutoFallbackHybridComponentContainer;
import com.bytedance.android.livesdk.chatroom.ui.m5;
import com.bytedance.android.livesdk.chatroom.ui.n5;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/FullHybridViewFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FullHybridViewFragment extends BaseFragment {
    public static final /* synthetic */ int h = 0;
    public String d;
    public AutoFallbackHybridComponentContainer e;
    public View f;
    public Disposable g;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        AutoFallbackHybridComponentContainer r0 = this.e;
        if (r0 == null) goto L7;
        HybridCard r1 = r0.c;
        if (r1 == null) goto L7;
        r1.setOnTouchListener(null);
        r0.removeView(r0.c);
        r0.c.release();
        r0.c = null;
    L7:
        super.onDestroy();
        Disposable r2 = this.g;
        if (r2 == null) goto L11;
        r2.dispose();
        return;
    }

    public FullHybridViewFragment() {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.android.livesdk.chatroom.ui.m5] */
    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        View r9 = r6.inflate(2131566096, r7, false);
        this.f = r9;
        if (r9 == null) goto L5;
        final AutoFallbackHybridComponentContainer r10 = (AutoFallbackHybridComponentContainer) r9.findViewById(2131373345);
    L6:
        this.e = r10;
        String r11 = this.d;
        if (r11 == null) goto L37;
        if (r10 == null) goto L37;
        if (TextUtils.isEmpty(r11) == true) goto L24;
        Map<String, String> r1 = r10.b;
        if (r1 == null) goto L24;
        if (r1.isEmpty() == true) goto L24;
        Uri r12 = UriProtector.parse(r11);
        Uri.Builder r2 = r12.buildUpon();
        Set r13 = UriProtector.getQueryParameterNames(r12);
        Iterator<String> r3 = r10.b.keySet().iterator();
    L19:
        if (r3.hasNext() == false) goto L23;
        String r4 = r3.next();
        if (r13.contains(r4) == true) goto L19;
        r2.appendQueryParameter(r4, r10.b.get(r4));
        goto L19
    L23:
        r11 = r2.build().toString();
    L24:
        r10.a = r11;
        r10.d = new m5(r10);
        Uri r14 = x6.a.d(r11);
        IBrowserService r5 = k.f(IBrowserService.class);
        if (r5 != null) goto L28;
        r10.b("lynx view create error. browser service is null, url is " + r10.a);
        goto L37
    L28:
        if (TextUtils.isEmpty(r10.a) == false) goto L30;
        r10.b("view create error. url is null");
        goto L37
    L30:
        HybridCard r15 = r10.c;
        if (r15 == null) goto L33;
        r15.setOnTouchListener(null);
        r10.removeView(r10.c);
        r10.c.release();
        r10.c = null;
    L33:
        HybridCard r16 = r5.getHybridCard(r10.getContext(), r14, new n5(r10));
        r10.c = r16;
        if (r16 != null) goto L36;
        r10.b("view create error. component is null, url is " + r10.a);
        goto L37
    L36:
        r16.setOnTouchListener(r10.d);
        r10.c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r10.addView(r10.c, 0);
        r10.c.load(null, null);
    L37:
        this.g = k.n(IBrowserService.class).registerJsEventSubscriber("poster_detail_close").observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.chatroom.vs.video.a(this));
        return this.f;
    L5:
        r10 = null;
        goto L6
    }
}
