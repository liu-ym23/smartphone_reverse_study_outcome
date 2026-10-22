package com.larus.agents.impl.webfetch;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedInput;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g implements t {
    public final /* synthetic */ Call<TypedInput> a;

    public final e a() {
        return new e(this.a.execute());
    }

    @Override // com.larus.agents.impl.webfetch.t
    public final void cancel() {
        this.a.cancel();
    }

    public g(Call<TypedInput> r1) {
        this.a = r1;
    }
}
