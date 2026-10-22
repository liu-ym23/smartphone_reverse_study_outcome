package mab;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements a<String> {
    public final List<String> a;

    @Override // mab.a
    public final int getItemsCount() {
        return this.a.size();
    }

    @Override // mab.a
    public final String a() {
        return UIHelper.getString(2131887086);
    }

    public f(List<String> r1) {
        this.a = r1;
    }

    public final String b(int r2) {
        if (CollectionUtils.isNotEmpty(this.a) == true) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        if (r2 < getItemsCount()) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return (String) ListProtector.get(this.a, r2);
    }

    @Override // mab.a
    public final /* bridge */ /* synthetic */ String getItem(int r1) {
        return b(r1);
    }

    @Override // mab.a
    public final int indexOf(String r2) {
        List<String> r0 = this.a;
        return r0.indexOf(r2);
    }
}
