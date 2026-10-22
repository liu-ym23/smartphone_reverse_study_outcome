package com.obric.aiproactive.impl.bridge;

import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0019\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteArtifactResponse;", "Ljava/io/Closeable;", "statusCode", "", "contentType", "", "contentLength", "", "redirectLocation", "body", "Ljava/io/InputStream;", "closeAction", "Lkotlin/Function0;", "", "<init>", "(ILjava/lang/String;JLjava/lang/String;Ljava/io/InputStream;Lkotlin/jvm/functions/Function0;)V", "getStatusCode", "()I", "getContentType", "()Ljava/lang/String;", "getContentLength", "()J", "getRedirectLocation", "getBody", "()Ljava/io/InputStream;", IslandSession.REOPEN_VALUE_CLOSE, "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6419b;
    private final long c;
    private final String d;
    private final InputStream e;
    private final Function0<Unit> f;

    public j(int r3, String r4, long r5, String r7, InputStream r8, Function0<Unit> r9) {
        Function0<Unit> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "closeAction");
        this.f6418a = r3;
        this.f6419b = r4;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r10;
    }

    public final int a() {
        return this.f6418a;
    }

    public final String b() {
        return this.f6419b;
    }

    public final long c() {
        return this.c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.invoke();
    }

    public final String d() {
        return this.d;
    }

    public final InputStream e() {
        return this.e;
    }
}
