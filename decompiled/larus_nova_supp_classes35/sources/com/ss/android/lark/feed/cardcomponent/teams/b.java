package com.ss.android.lark.feed.cardcomponent.teams;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.biz.im.api.FeedTeamInfo;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends FeedCardComponent<C0201b, FeedTeamView> {
    public final int c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.cardcomponent.teams.b$b, reason: collision with other inner class name */
    public static final class C0201b {
        public final List<FeedTeamInfo> a;

        public C0201b(List<FeedTeamInfo> r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        return new FeedTeamView(getContext(), null, 6, 0);
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        return new ConstraintLayout.LayoutParams(0, this.c);
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = zz7.b.g(r2, 20);
    }
}
