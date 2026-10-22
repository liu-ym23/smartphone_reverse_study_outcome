package com.obric.memorydata.ability;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/ability/IAbilityContext;", "Lcom/obric/memorydata/ability/IAbilityManager;", "getAndroidContext", "Landroid/content/Context;", "publish", "", "standardData", "Lcom/obric/memorydata/ability/data/IStandardData;", "publishToReceiver", "key", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface j extends l {
    Context a();

    boolean a(com.obric.memorydata.ability.data.h r1);

    boolean a(String r1, com.obric.memorydata.ability.data.h r2);
}
