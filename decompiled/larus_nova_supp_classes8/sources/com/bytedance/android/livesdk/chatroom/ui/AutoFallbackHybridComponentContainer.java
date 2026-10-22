package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class AutoFallbackHybridComponentContainer extends FrameLayout implements com.bytedance.android.live.browser.jsbridge.f {
    public static final /* synthetic */ int e = 0;
    public String a;
    public Map<String, String> b;
    public HybridCard c;
    public m5 d;

    public interface a {
    }

    public void setListener(a r1) {
    }

    public final void a() {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        TextView r0 = new TextView(getContext());
        r0.setBackgroundColor(-16711936);
        r0.setTextColor(-1);
        r0.setText("null");
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 0;
        r0.setLayoutParams(r1);
        addView(r0);
        return;
    }

    public AutoFallbackHybridComponentContainer(Context r1) {
        super(r1);
        a();
    }

    public final void b(String r2) {
        ALogger.i("AutoFallbackHybridComponentContainer", r2);
    }

    public void setParams(Map<String, String> r1) {
        this.b = r1;
    }

    public AutoFallbackHybridComponentContainer(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public AutoFallbackHybridComponentContainer(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
