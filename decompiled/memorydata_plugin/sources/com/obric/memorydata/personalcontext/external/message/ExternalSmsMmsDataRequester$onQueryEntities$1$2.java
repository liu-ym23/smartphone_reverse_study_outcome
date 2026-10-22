package com.obric.memorydata.personalcontext.external.message;

import android.content.ContentResolver;
import android.database.Cursor;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ExternalSmsMmsDataRequester$onQueryEntities$1$2 extends FunctionReferenceImpl implements Function3<ContentResolver, Cursor, b.a, MessageEntity> {
    ExternalSmsMmsDataRequester$onQueryEntities$1$2(Object r8) {
        super(3, r8, b.class, "createEntityFromMms", "createEntityFromMms(Landroid/content/ContentResolver;Landroid/database/Cursor;Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsDataRequester$ColumnMap;)Lcom/obric/capabilitykit/entity/app/MessageEntity;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MessageEntity invoke2(ContentResolver r3, Cursor r4, b.a r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "p0");
        Intrinsics.checkNotNullParameter(r6, "p1");
        Intrinsics.checkNotNullParameter(r5, "p2");
        return b.b((b) ZeusTransformUtils.preCheckCast(this.receiver, b.class, "com.obric.memorydata.plugin"), r3, r6, r5);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ MessageEntity invoke(ContentResolver r3, Cursor r4, b.a r5) {
        return invoke2((ContentResolver) ZeusTransformUtils.preCheckCast(r3, ContentResolver.class, "com.obric.memorydata.plugin"), (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin"), (b.a) ZeusTransformUtils.preCheckCast(r5, b.a.class, "com.obric.memorydata.plugin"));
    }
}
