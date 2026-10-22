package com.bytedance.ies.ugc.aweme.network;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import be.a;
import be.b;
import com.krypton.annotation.OutService;

/* JADX INFO: loaded from: classes2.dex */
@OutService
@Keep
public interface IRetrofitFactory {
    b create(@NonNull String r5);

    a createBuilder(@NonNull String r5);
}
