package n4a;

import android.text.TextUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x3 extends a5 {
    public Map<String, String> k;
    public Map<String, String> l;
    public String m;
    public byte[] n;
    public String o;

    public x3() {
        this.k = null;
        this.l = null;
        this.m = NameKeys.UnloadStrategy_No_Strategy;
        this.n = null;
        this.o = null;
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        return this.k;
    }

    @Override // com.loc.bo
    public final String c() {
        return this.m;
    }

    @Override // n4a.a5, com.loc.bo
    public final String e() {
        if (TextUtils.isEmpty(this.o) == true) goto L7;
        return this.o;
    L7:
        return super.e();
    }

    @Override // com.loc.bo
    public final Map<String, String> h() {
        return this.l;
    }

    @Override // com.loc.bo
    public final byte[] i() {
        return this.n;
    }
}
