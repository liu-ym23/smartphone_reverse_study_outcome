package f3b;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.base.view.vo.message.e;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.utils.r0;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import j6b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements f2b.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final boolean g;
    public final boolean h;
    public final y6b.a i;

    @Override // f2b.a
    public final boolean a() {
        return this.i.h();
    }

    @Override // f2b.a
    public final String e() {
        y6b.a r0 = this.i;
        if (r0 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        return r0.g();
    }

    @Override // f2b.a
    public final String getMessageId() {
        return this.i.getId();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [v5b.a] */
    public final Map<String, PreviewHangPoint> h() {
        ?? r0 = this.i.b();
        if ((r0 instanceof e) == true) goto L13;
        if ((r0 instanceof PostContentVO) == true) goto L13;
        Map<String, PreviewHangPoint> r1 = j();
        if (r1 == null) goto L11;
        return r1;
    L11:
        return new HashMap();
    L13:
        return k.b(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DocResult i() {
        T r0 = this.i.b();
        if ((r0 instanceof e) == false) goto L7;
        return ((e) r0).i;
    L7:
        if ((r0 instanceof PostContentVO) == true) goto L9;
        return null;
    L9:
        return ((PostContentVO) r0).i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, PreviewHangPoint> j() {
        T r0 = this.i.b();
        if ((r0 instanceof e) == false) goto L7;
        return ((e) r0).C;
    L7:
        if ((r0 instanceof PostContentVO) == false) goto L11;
        return ((PostContentVO) r0).C;
    L11:
        if ((r0 instanceof FileContentVO) == true) goto L13;
        return null;
    L13:
        return ((FileContentVO) r0).j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final MessageUrlPreview n() {
        T r0 = this.i.b();
        if ((r0 instanceof e) == false) goto L6;
        MessageUrlPreview r1 = ((e) r0).h;
    L9:
        if (r1 != null) goto L11;
    L13:
        return null;
    L11:
        if (r1.isDeleted() == true) goto L13;
        return r1;
    L6:
        if ((r0 instanceof PostContentVO) == false) goto L8;
        r1 = ((PostContentVO) r0).h;
        goto L9
    L8:
        r1 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Integer k() {
        if (i() == null) goto L17;
        if (r0.f(i(), this.i.h()) == false) goto L17;
        T r0 = this.i.b();
        if ((r0 instanceof e) == false) goto L10;
        PreviewHangPoint r1 = ((e) r0).j;
    L13:
        if (r1 != null) goto L17;
        return 2;
    L10:
        if ((r0 instanceof PostContentVO) == false) goto L12;
        r1 = ((PostContentVO) r0).j;
        goto L13
    L12:
        r1 = null;
    L17:
        if (CollectionUtils.isEmpty(j()) == true) goto L29;
        Iterator<Map.Entry<String, PreviewHangPoint>> r2 = h().entrySet().iterator();
    L20:
        if (r2.hasNext() == false) goto L24;
        if (r2.next().getValue().isValidCardData() == false) goto L20;
        boolean r3 = true;
    L25:
        if (r3 == false) goto L29;
        return 4;
    L24:
        r3 = false;
    L29:
        if (n() == null) goto L33;
        return 1;
    L33:
        return 0;
    }

    public final int m() {
        return h().size();
    }

    @Override // f2b.a
    public final String b() {
        return this.a;
    }

    @Override // f2b.a
    public final String c() {
        return this.f;
    }

    @Override // f2b.a
    public final String d() {
        return this.d;
    }

    @Override // f2b.a
    public final String f() {
        return this.c;
    }

    @Override // f2b.a
    public final y6b.a g() {
        return this.i;
    }

    @Override // f2b.a
    public final String getChatId() {
        return this.e;
    }

    @Override // f2b.a
    public final String getP2pChatterId() {
        return this.b;
    }

    @Override // f2b.a
    public final boolean isCrossTenant() {
        return this.h;
    }

    @Override // f2b.a
    public final boolean isGroup() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final h2b.a l(int r5) {
        if (r5 == 1) goto L32;
        if (r5 == 2) goto L30;
        if (r5 == 4) goto L10;
        return null;
    L10:
        Map<String, PreviewHangPoint> r0 = h();
        T r1 = this.i.b();
        if ((r1 instanceof e) == false) goto L14;
        Map r2 = ((e) r1).B;
    L20:
        T r3 = this.i.b();
        if ((r3 instanceof e) == false) goto L24;
        List r4 = k.a(((e) r3).g(), j());
    L28:
        return new h2b.c(r0, r2, r4, false);
    L24:
        if ((r3 instanceof PostContentVO) == false) goto L26;
        r4 = k.a(((PostContentVO) r3).g(), j());
        goto L28
    L26:
        r4 = new ArrayList();
        goto L28
    L14:
        if ((r1 instanceof PostContentVO) == false) goto L17;
        r2 = ((PostContentVO) r1).B;
        goto L20
    L17:
        if ((r1 instanceof FileContentVO) == false) goto L19;
        r2 = ((FileContentVO) r1).B;
        goto L20
    L19:
        r2 = new HashMap();
        goto L20
    L30:
        return new h2b.b(i());
    L32:
        return new h2b.d(n());
    }

    public d(y6b.a r2, Chat r3, y6b.b r4) {
        this.a = BuildConfig.FLAVOR;
        this.d = BuildConfig.FLAVOR;
        this.i = r2;
        if (r4 == null) goto L5;
        this.a = r4.c;
        this.b = r4.a;
        this.c = r4.k;
    L5:
        if (r3 == null) goto L7;
        this.e = r3.getId();
        this.d = r3.getName();
        this.f = r3.getAvatarKey();
        this.h = r3.isCrossTenant();
    L7:
        if (r3 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        this.g = r5;
        return;
    L9:
        if (r3.isGroup() == false) goto L11;
        r5 = true;
        goto L12
    }
}
