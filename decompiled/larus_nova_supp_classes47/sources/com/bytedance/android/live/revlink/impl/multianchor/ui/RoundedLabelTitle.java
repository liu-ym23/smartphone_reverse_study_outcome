package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000f\u0010\u0013B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u000f\u0010\u0016J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/RoundedLabelTitle;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "getCurrentPlayMode", "getPlayMode", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/RoundedLabelTitle$c;", "d", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/RoundedLabelTitle$c;", "getOnTapPlayModeListener", "()Lcom/bytedance/android/live/revlink/impl/multianchor/ui/RoundedLabelTitle$c;", "setOnTapPlayModeListener", "(Lcom/bytedance/android/live/revlink/impl/multianchor/ui/RoundedLabelTitle$c;)V", "onTapPlayModeListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoundedLabelTitle extends FrameLayout {
    public Map<Integer, View> a;
    public final Map<PlayMode, View> b;
    public PlayMode c;
    public c d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ RoundedLabelTitle a;

        public a(RoundedLabelTitle r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RoundedLabelTitle r3 = this.a;
            PlayMode r0 = PlayMode.PERSONAL_PK;
            c r4 = r3.d;
            if (r4 == null) goto L6;
            r4.a(r0);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RoundedLabelTitle a;

        public b(RoundedLabelTitle r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RoundedLabelTitle r3 = this.a;
            PlayMode r0 = PlayMode.TEAM_PK;
            c r4 = r3.d;
            if (r4 == null) goto L6;
            r4.a(r0);
            return;
        }
    }

    public interface c {
        void a(PlayMode r1);
    }

    public final PlayMode getCurrentPlayMode() {
        return this.c;
    }

    public final c getOnTapPlayModeListener() {
        return this.d;
    }

    public final PlayMode getPlayMode() {
        return this.c;
    }

    public RoundedLabelTitle(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.a = new LinkedHashMap();
        HashMap r6 = new HashMap();
        this.b = r6;
        LayoutInflater.from(getContext()).inflate(2131567015, this);
        ((TextView) a(2131382191)).setOnClickListener(new a(this));
        ((TextView) a(2131388295)).setOnClickListener(new b(this));
        r6.put(PlayMode.PERSONAL_PK, a(2131382191));
        r6.put(PlayMode.TEAM_PK, a(2131388295));
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

    public final void b(PlayMode r5) {
        Intrinsics.checkNotNullParameter(r5, "playMode");
        if (this.c != r5) goto L5;
        return;
    L5:
        this.c = r5;
        TextView r0 = (TextView) a(2131382191);
        boolean r2 = false;
        if (r5 != PlayMode.PERSONAL_PK) goto L8;
        boolean r1 = true;
    L9:
        r0.setSelected(r1);
        TextView r3 = (TextView) a(2131388295);
        if (r5 != PlayMode.TEAM_PK) goto L12;
        r2 = true;
    L12:
        r3.setSelected(r2);
        View r6 = (View) ((HashMap) this.b).get(r5);
        if (r6 == null) goto L16;
        r6.bringToFront();
        return;
    L16:
        return;
    L8:
        r1 = false;
        goto L9
    }

    public final void setOnTapPlayModeListener(c r1) {
        this.d = r1;
    }

    public RoundedLabelTitle(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.a = new LinkedHashMap();
        HashMap r6 = new HashMap();
        this.b = r6;
        LayoutInflater.from(getContext()).inflate(2131567015, this);
        ((TextView) a(2131382191)).setOnClickListener(new a(this));
        ((TextView) a(2131388295)).setOnClickListener(new b(this));
        r6.put(PlayMode.PERSONAL_PK, a(2131382191));
        r6.put(PlayMode.TEAM_PK, a(2131388295));
    }

    public RoundedLabelTitle(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = new LinkedHashMap();
        HashMap r6 = new HashMap();
        this.b = r6;
        LayoutInflater.from(getContext()).inflate(2131567015, this);
        ((TextView) a(2131382191)).setOnClickListener(new a(this));
        ((TextView) a(2131388295)).setOnClickListener(new b(this));
        r6.put(PlayMode.PERSONAL_PK, a(2131382191));
        r6.put(PlayMode.TEAM_PK, a(2131388295));
    }
}
