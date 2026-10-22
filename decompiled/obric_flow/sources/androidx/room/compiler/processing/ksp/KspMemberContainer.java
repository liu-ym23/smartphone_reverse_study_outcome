package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XMemberContainer;
import il.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "Landroidx/room/compiler/processing/XMemberContainer;", "Landroidx/room/compiler/processing/ksp/KspType;", "getType", "()Landroidx/room/compiler/processing/ksp/KspType;", "type", "Lil/d;", "getDeclaration", "()Lil/d;", "declaration", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface KspMemberContainer extends XMemberContainer {
    d getDeclaration();

    @Override // androidx.room.compiler.processing.XMemberContainer
    KspType getType();
}
