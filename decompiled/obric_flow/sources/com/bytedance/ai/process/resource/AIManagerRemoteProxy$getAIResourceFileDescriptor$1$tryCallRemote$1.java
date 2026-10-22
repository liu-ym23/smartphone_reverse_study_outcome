package com.bytedance.ai.process.resource;

import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.process.resource.AIManagerRemoteProxy$getAIResourceFileDescriptor$1", f = "AIManagerRemoteProxy.kt", i = {0, 0, 0}, l = {ComposerKt.compositionLocalMapKey}, m = "invokeSuspend$tryCallRemote", n = {"$sessionId", "$url", "fileCallback"}, s = {"L$0", "L$1", "L$2"})
final class AIManagerRemoteProxy$getAIResourceFileDescriptor$1$tryCallRemote$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f2433c;
    public /* synthetic */ Object d;
    public int e;

    public AIManagerRemoteProxy$getAIResourceFileDescriptor$1$tryCallRemote$1(ContinuationImpl r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.d = r5;
        this.e |= Integer.MIN_VALUE;
        return AIManagerRemoteProxy$getAIResourceFileDescriptor$1.a(null, null, null, this);
    }
}
