package com.obric.memorydata.personalcontext.search.global;

import android.os.Bundle;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.sdk.entity.search.GlobalQUResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\bH\u0094@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/DoubaoAbstractGlobalAssistantSearchSession;", "Lcom/obric/memorydata/personalcontext/search/global/AbstractGlobalAssistantSearchSession;", "startTime", "", "userQuery", "", "queryId", "quResult", "Lcom/obric/memorydata/sdk/entity/search/GlobalQUResult;", "entitySearchRecordInfo", "Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "inputType", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/sdk/entity/search/GlobalQUResult;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;Ljava/lang/String;)V", "getQuUnderStandingResult", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSwitchStatusOffDomains", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e extends com.obric.memorydata.personalcontext.search.global.a {
    public static final a d = null;
    private final long e;
    private final String f;
    private final String g;
    private final GlobalQUResult h;
    private final EntitySearchRecordInfo i;
    private final String j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/DoubaoAbstractGlobalAssistantSearchSession$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        d = new a(null);
    }

    public e(long r14, String r16, String r17, GlobalQUResult r18, EntitySearchRecordInfo r19, String r20) {
        Intrinsics.checkNotNullParameter(r16, "userQuery");
        Intrinsics.checkNotNullParameter(r17, "queryId");
        Intrinsics.checkNotNullParameter(r18, "quResult");
        Intrinsics.checkNotNullParameter(r20, "inputType");
        super(r14, new Bundle(), r17, r16, r19, r20);
        this.e = r14;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
    }

    @Override // com.obric.memorydata.personalcontext.search.global.a
    public Object a(Continuation<? super GlobalQUResult> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return this.h;
    }

    @Override // com.obric.memorydata.personalcontext.search.global.a
    public Set<String> h() {
        return com.obric.memorydata.personalcontext.search.a.f12274a.a();
    }
}
