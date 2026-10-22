package com.obric.memorydata.awareness.impl.gate;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&J \u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\tH&J*\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\u0010H&J\b\u0010\u0011\u001a\u00020\u000bH&¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchValueProvider;", "", "getBoolean", "", "repo", "", "key", "defaultValue", "getInt", "", "replaceObservedKeys", "", "keys", "", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchKey;", "onChanged", "Lkotlin/Function1;", "release", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface d {
    int a(String r1, String r2, int r3);

    void a(Set<c> r1, Function1<? super c, Unit> r2);

    boolean a(String r1, String r2, boolean r3);
}
