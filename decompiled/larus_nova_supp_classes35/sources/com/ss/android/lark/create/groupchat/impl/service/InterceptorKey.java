package com.ss.android.lark.create.groupchat.impl.service;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.MapKey;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@MapKey
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/create/groupchat/impl/service/InterceptorKey;", BuildConfig.FLAVOR, "value", "Lcom/ss/android/lark/create/groupchat/impl/service/InterceptorType;", "()Lcom/ss/android/lark/create/groupchat/impl/service/InterceptorType;", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface InterceptorKey {
    InterceptorType value();
}
