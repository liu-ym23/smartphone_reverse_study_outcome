package com.bytedance.android.livesdk.dynamicstrategy.api;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import iu1.b;
import java.util.List;
import ju1.n;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface IDynamicStrategyContext {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext$Scope;", "", "GLOBAL", "LIVE_ROOM", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Scope extends Enum<Scope> {
        public static final Scope GLOBAL = null;
        public static final Scope LIVE_ROOM = null;
        public static final /* synthetic */ Scope[] a = null;

        static {
            Scope r1 = new Scope("GLOBAL", 0);
            GLOBAL = r1;
            Scope r2 = new Scope("LIVE_ROOM", 1);
            LIVE_ROOM = r2;
            a = new Scope[]{r1, r2};
        }

        public static Scope valueOf(String r1) {
            return (Scope) a.a(Scope.class, r1);
        }

        public static Scope[] values() {
            return (Scope[]) a.clone();
        }

        public Scope(String r1, int r2) {
            super(r1, r2);
        }
    }

    PropertyOwner<n> getStrategy(String r1);

    void upsertFactors(List<? extends DynamicFactor<? extends Object>> r1);

    void upsertStrategy(List<? extends b> r1);
}
