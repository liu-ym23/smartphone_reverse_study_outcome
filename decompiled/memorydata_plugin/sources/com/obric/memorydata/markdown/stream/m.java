package com.obric.memorydata.markdown.stream;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/markdown/stream/StreamSources;", "", "<init>", "()V", "InputStreamSource", "FlowSource", "ChannelWebSocketSource", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f10029a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/markdown/stream/StreamSources$ChannelWebSocketSource;", "Lcom/obric/memorydata/markdown/stream/StreamSource;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "<init>", "(Lkotlinx/coroutines/channels/ReceiveChannel;)V", "asFlow", "Lkotlinx/coroutines/flow/Flow;", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final y<String> f10030a;

        public static final /* synthetic */ y a(a r0) {
            return r0.f10030a;
        }

        @Override // com.obric.memorydata.markdown.stream.l
        public kotlinx.coroutines.flow.i<String> a() {
            return kotlinx.coroutines.flow.k.a((Function2) ZeusTransformUtils.preCheckCast(new StreamSources$ChannelWebSocketSource$asFlow$1(this, null), Function2.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/markdown/stream/StreamSources$FlowSource;", "Lcom/obric/memorydata/markdown/stream/StreamSource;", "upstream", "Lkotlinx/coroutines/flow/Flow;", "", "<init>", "(Lkotlinx/coroutines/flow/Flow;)V", "asFlow", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlinx.coroutines.flow.i<String> f10031a;

        public b(kotlinx.coroutines.flow.i<String> r3) {
            kotlinx.coroutines.flow.i<String> r4 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "upstream");
            this.f10031a = r4;
        }

        @Override // com.obric.memorydata.markdown.stream.l
        public kotlinx.coroutines.flow.i<String> a() {
            return this.f10031a;
        }
    }

    static {
        f10029a = new m();
    }

    private m() {
    }
}
