package com.bytedance.applog.priority.original;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH&Jd\u0010\u000e\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011`\u0012\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00152\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00130\u0019H&J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u001f"}, d2 = {"Lcom/bytedance/applog/priority/original/DatabaseInterface;", "", "clear", "", CommonConsts.COUNT_TYPE, "", "groupId", "deleteAll", "keys", "", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "destroy", "getAllGroupIds", "", "getBySizeAndCount", "Lkotlin/Pair;", "Ljava/util/HashMap;", "Lorg/json/JSONObject;", "Lkotlin/collections/HashMap;", "", "maxSize", "", "maxCount", "eventTtl", "filter", "Lkotlin/Function1;", "insert", "key", EventBody.KEY_VALUE, "", "isEmpty", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface g {
    int a(int r1);

    Set<Integer> a();

    Pair<HashMap<Model.a, JSONObject>, Boolean> a(int r1, long r2, int r4, long r5, Function1<? super JSONObject, Boolean> r7);

    void a(Iterable<Model.a> r1);

    void b();

    boolean b(int r1);

    Model.a insert(Model.a r1, String r2);
}
