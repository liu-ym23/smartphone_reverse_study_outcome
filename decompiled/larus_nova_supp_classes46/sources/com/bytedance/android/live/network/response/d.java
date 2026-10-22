package com.bytedance.android.live.network.response;

import com.bytedance.android.live.base.model.Extra;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class d<DATA, EXTRA extends Extra> extends ExtraResponse<DATA, EXTRA> {

    public static final class a extends d<Object, Extra> implements c {
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

        public a(int r2, RequestError r3, Extra r4) {
            super(Unit.INSTANCE, r4);
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }
    }

    public static final class b extends d<Object, Extra> {
        public b(Object r1, Extra r2) {
            super(r1, r2);
        }
    }

    public d() {
        throw null;
    }

    public final String toString() {
        return "ExtraResponse<" + this.data.getClass().getCanonicalName() + ", " + this.extra.getClass().getCanonicalName() + "> : { log_id: " + this.logId + ", data: " + this.data + ", extra: " + this.extra + " }";
    }

    public d(Object r1, Extra r2) {
        super(r1, r2);
    }
}
