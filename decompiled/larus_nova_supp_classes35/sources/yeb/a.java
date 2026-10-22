package yeb;

import androidx.fragment.app.Fragment;
import bw7.b;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.export.feedcard.g;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements d {
    public final d a;
    public final g b;
    public final b c;

    @Override // com.ss.android.lark.feed.export.feedcard.d
    public final deb.d b() {
        return null;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.d
    public final s c() {
        return this.a.c();
    }

    @Override // com.ss.android.lark.feed.export.feedcard.d
    public final s e() {
        return this.a.e();
    }

    @Override // com.ss.android.lark.feed.export.feedcard.d
    public final FeedFolder f() {
        return this.a.f();
    }

    @Override // com.ss.android.lark.feed.export.feedcard.d
    public final l g() {
        return this.a.g();
    }

    @Override // com.ss.android.lark.feed.export.feedcard.d
    public final Fragment getHost() {
        return this.a.getHost();
    }

    @Override // com.ss.android.lark.feed.export.feedcard.d
    public final g a() {
        return this.b;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.d
    public final b d() {
        return this.c;
    }

    public a(d r2, FeedListAdapter.d r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "hostContext");
        Intrinsics.checkNotNullParameter(r3, "adapterContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
