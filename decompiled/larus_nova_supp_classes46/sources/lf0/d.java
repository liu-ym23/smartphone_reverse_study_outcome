package lf0;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.g;
import com.bytedance.android.live.liveinteract.interact.audience.ui.StarView;
import com.bytedance.android.live.ui.PingFangSCTextView;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends FrameLayout {
    public Map<Integer, View> a;
    public final Integer[] b;
    public k c;
    public k d;
    public long e;
    public float f;
    public View.OnClickListener g;
    public View.OnClickListener h;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        return true;
    }

    public final k getAvatar() {
        return this.d;
    }

    public final k getLabel() {
        return this.c;
    }

    public final long getNumOfLink() {
        return this.e;
    }

    public final View.OnClickListener getOnCloseClickListener() {
        return this.h;
    }

    public final View.OnClickListener getOnConfirmClickListener() {
        return this.g;
    }

    public final float getScore() {
        return this.f;
    }

    public final Integer[] getStarsId() {
        return this.b;
    }

    public d(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r3).inflate(2131566212, this);
        this.b = new Integer[]{2131387186, 2131387187, 2131387188, 2131387189, 2131387190};
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setAnchor(boolean r3) {
        PingFangSCTextView r0 = a(2131390381);
        Resources r1 = getContext().getResources();
        if (r3 == false) goto L5;
        int r4 = 2131917982;
    L6:
        r0.setText(r1.getString(r4));
        return;
    L5:
        r4 = 2131917979;
        goto L6
    }

    public final void setAvatar(k r4) {
        this.d = r4;
        HSImageView r1 = a(2131374960);
        if (r4 == null) goto L5;
        int r2 = 0;
    L6:
        r1.setVisibility(r2);
        if (r4 == null) goto L10;
        ImageLoader.load(r4).a(a(2131374960));
        return;
    L10:
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public final void setLabel(k r4) {
        this.c = r4;
        HSImageView r1 = a(2131383250);
        if (r4 == null) goto L5;
        int r2 = 0;
    L6:
        r1.setVisibility(r2);
        if (r4 == null) goto L10;
        ImageLoader.load(r4).a(a(2131383250));
        return;
    L10:
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public final void setNumOfLink(long r5) {
        if (r5 >= 0) goto L5;
        return;
    L5:
        this.e = r5;
        PingFangSCTextView r0 = a(2131390392);
        if (r5 == 0) goto L8;
        String r6 = getContext().getResources().getString(2131917980, new Object[]{Long.valueOf(r5)});
    L9:
        r0.setText(r6);
        return;
    L8:
        r6 = getContext().getResources().getString(2131917981);
        goto L9
    }

    public final void setOnCloseClickListener(View.OnClickListener r2) {
        this.h = r2;
        a(2131374967).setOnClickListener(r2);
    }

    public final void setOnConfirmClickListener(View.OnClickListener r2) {
        this.g = r2;
        a(2131390381).setOnClickListener(r2);
    }

    public final void setScore(float r8) {
        if (r8 >= 0.0f) goto L5;
    L18:
        HashMap r0 = new HashMap();
        r0.put("log", "score set not within boundary, score " + r8);
        g.s("ProfileCard", r0);
        return;
    L5:
        if (r8 > 5.0f) goto L18;
        this.f = r8;
        Integer[] r1 = this.b;
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L17;
        int r4 = r1[r3].intValue();
        if (r8 <= 0.0f) goto L24;
        if (r8 >= 1.0f) goto L15;
        ((StarView) findViewById(r4)).setPercent(r8);
        r8 = 0.0f;
    L16:
        r3 = r3 + 1;
        goto L8
    L15:
        ((StarView) findViewById(r4)).setPercent(1.0f);
        r8 = r8 - 1.0f;
        goto L16
    L24:
        return;
    }
}
