package com.larus.doc.impl.chat.component;

import android.os.Bundle;
import com.larus.doc.impl.chat.data.DocArtifactInfo;
import com.larus.network.http.HttpExtKt;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import va8.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u001c\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/larus/doc/impl/chat/component/DocArtifactComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/doc/impl/chat/ability/IDocArtifactAbility;", "<init>", "()V", "data", "Lcom/larus/doc/impl/chat/data/DocArtifactInfo;", "actionBarSceneAbility", "Lcom/larus/bmhome/ability/IChatSceneAbility;", "getActionBarSceneAbility", "()Lcom/larus/bmhome/ability/IChatSceneAbility;", "actionBarSceneAbility$delegate", "Lkotlin/Lazy;", "onAttach", "", "setArtifact", "artifact", "setArtifactExt", "map", "", "", "getCurDocId", "getArtifact", "updateArtifactInfo", "artifactMetaId", "artifactVersionId", "conversationId", "bindedMessageId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocArtifactComponent extends Component implements g39.a {
    public DocArtifactInfo l;
    public final Lazy m;

    public static final class a {
    }

    public static final class b implements Function0<r> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(r.class));
        }
    }

    static {
    }

    @Override // g39.a
    public final String Q40() {
        return null;
    }

    @Override // g39.a
    public final String Y0() {
        return null;
    }

    @Override // g39.a
    public final String oh() {
        return null;
    }

    @Override // g39.a
    public final String r1() {
        return null;
    }

    @Override // g39.a
    public final String w0() {
        return null;
    }

    @Override // g39.a
    public final String RR() {
        DocArtifactInfo r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getResourceId();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        String r3 = null;
        if (r1 == null) goto L5;
        String r2 = r1.getString("key_doc_id", "");
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r4 == null) goto L9;
        r3 = r4.getString("artifact_meta_id", "");
    L9:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        int r5 = 3;
        if (r0 == null) goto L12;
        r5 = r0.getInt("resource_type", 3);
    L12:
        FLogger.a.i("DocArtifactComponent", "onAttach, resourceId = " + r2 + ", artifactMetaId = " + r3);
        this.l = new DocArtifactInfo(r3, r2, r5);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public DocArtifactComponent() {
        this.m = LazyKt.lazy(new b(this));
    }

    @Override // g39.a
    public final DocArtifactInfo X4() {
        return this.l;
    }

    @Override // g39.a
    public final void aT(DocArtifactInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "artifact");
        this.l = r2;
    }

    @Override // g39.a
    public final void u2(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        r r0 = (r) this.m.getValue();
        if (r0 == null) goto L5;
        String r1 = r0.WE();
    L7:
        if (Intrinsics.areEqual(r1, "doc_create_list") == false) goto L9;
        return;
    L9:
        DocArtifactInfo r2 = this.l;
        if (r2 == null) goto L16;
        String r4 = HttpExtKt.p(r2);
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        String r5 = r3.put("artifact_block", r4);
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // g39.a
    public final void F8(String r7, String r8, String r9, String r10) {
        FLogger.a.i("DocArtifactComponent", "updateArtifactId, artifactId = " + r7);
        DocArtifactInfo r0 = this.l;
        if (r0 == null) goto L5;
        DocArtifactInfo r11 = DocArtifactInfo.copy$default(r0, r7, null, 0, 6, null);
    L6:
        this.l = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }
}
