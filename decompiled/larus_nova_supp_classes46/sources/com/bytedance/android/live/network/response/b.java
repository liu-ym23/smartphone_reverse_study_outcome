package com.bytedance.android.live.network.response;

import com.bytedance.android.live.base.model.Extra;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b extends com.bytedance.android.live.network.response.a {

    public static final class a extends b implements c {
        public final int c;
        public final RequestError d;
        public final Extra e;

        @Override // com.bytedance.android.live.network.response.c
        public final Extra a() {
            return this.e;
        }

        @Override // com.bytedance.android.live.network.response.c
        public final RequestError getError() {
            return this.d;
        }

        @Override // com.bytedance.android.live.network.response.c
        public final int getStatusCode() {
            return this.c;
        }

        public a(int r1, RequestError r2, Extra r3) {
            super(r3);
            this.c = r1;
            this.d = r2;
            this.e = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.network.response.b$b, reason: collision with other inner class name */
    public static final class C0138b extends b {
        public C0138b(Extra r1) {
            super(r1);
        }
    }

    public final String toString() {
        return "EmptyResponse<" + ((Unit) this.data).getClass().getCanonicalName() + "> : { log_id: " + this.logId + ", extra: " + this.extra + " }";
    }

    public b(Extra r1) {
        super(r1);
    }
}
