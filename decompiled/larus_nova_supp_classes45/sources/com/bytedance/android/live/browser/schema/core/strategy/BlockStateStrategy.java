package com.bytedance.android.live.browser.schema.core.strategy;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BlockStateStrategy extends c {
    public static final /* synthetic */ int c = 0;
    public final List<String> b;

    public static final class a {
    }

    public static final class b implements c.b {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList] */
        @Override // com.bytedance.android.live.browser.schema.core.strategy.c.b
        public final c a(JSONObject r6) {
            Intrinsics.checkNotNullParameter(r6, "json");
            JSONArray r7 = r6.optJSONArray("blockKeys");
            if (r7 == null) goto L7;
            ?? r1 = new ArrayList();
            int r2 = r7.length();
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L9;
            r1.add(JSONArrayProtectorUtils.getString(r7, r3));
            r3 = r3 + 1;
        L9:
            return new BlockStateStrategy(r1);
        L7:
            r1 = CollectionsKt.emptyList();
            goto L9
        }
    }

    static {
    }

    public BlockStateStrategy(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
        super(3);
        this.b = r2;
    }

    @Override // com.bytedance.android.live.browser.schema.core.strategy.c
    public final boolean a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "currentState");
        if ((!this.b.isEmpty()) == false) goto L17;
        final JSONObject r0 = new JSONObject();
        r3.put("block_key", r0);
        Iterator r4 = SequencesKt.map(CollectionsKt.asSequence(this.b), new BlockStateStrategy$match$2(this, r0)).iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r1 = r4.next();
        if (((Boolean) r1).booleanValue() == false) goto L6;
    L11:
        Boolean r2 = (Boolean) r1;
        if (r2 != null) goto L21;
        return false;
    L21:
        return r2.booleanValue();
    L10:
        r1 = null;
        goto L11
    L17:
        throw new IllegalStateException("block keys not exists or keys is empty, please check config".toString());
    }
}
