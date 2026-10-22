package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmValueParameterExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015R&\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u000e\u001a\u00020 8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameter;", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "<init>", "(ILjava/lang/String;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitVarargElementType", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterExtensionVisitor;", "visitor", "", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;)V", "I", "getFlags", "()I", "setFlags", "(I)V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "getType", "()Ljava/lang/Object;", "setType", "(Ljava/lang/Object;)V", "varargElementType", "getVarargElementType", "setVarargElementType", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmValueParameterExtension;", "extensions", "Ljava/util/List;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmValueParameter extends KmValueParameterVisitor {
    private final List<KmValueParameterExtension> extensions;
    private int flags;
    private String name;
    public KmType type;
    private KmType varargElementType;

    public KmValueParameter(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        super(null, 1, null);
        this.flags = r5;
        this.name = r10;
        List<MetadataExtensions> r11 = MetadataExtensions.Companion.getINSTANCES();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        KmValueParameterExtension r14 = ((MetadataExtensions) r13.next()).createValueParameterExtension();
        if (r14 == null) goto L4;
        r12.add(r14);
        goto L4
    L8:
        this.extensions = r12;
    }

    public final void accept(KmValueParameterVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        KmTypeVisitor r10 = r5.visitType(getType().getFlags());
        if (r10 == null) goto L5;
        getType().accept(r10);
    L5:
        KmType r11 = this.varargElementType;
        if (r11 == null) goto L10;
        KmTypeVisitor r12 = r5.visitVarargElementType(r11.getFlags());
        if (r12 == null) goto L10;
        r11.accept(r12);
    L10:
        Iterator<T> r13 = this.extensions.iterator();
    L12:
        if (r13.hasNext() == false) goto L16;
        KmValueParameterExtension r14 = (KmValueParameterExtension) r13.next();
        KmValueParameterExtensionVisitor r15 = r5.visitExtensions(r14.getType());
        if (r15 == null) goto L12;
        r14.accept(r15);
        goto L12
    L16:
        r5.visitEnd();
    }

    public final int getFlags() {
        return this.flags;
    }

    public final String getName() {
        return this.name;
    }

    public final KmType getType() {
        KmType r5 = this.type;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public final KmType getVarargElementType() {
        return this.varargElementType;
    }

    public final void setFlags(int r5) {
        this.flags = r5;
    }

    public final void setName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.name = r5;
    }

    public final void setType(KmType r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.type = r5;
    }

    public final void setVarargElementType(KmType r5) {
        this.varargElementType = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor
    public KmValueParameterExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmValueParameterExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor
    public KmTypeVisitor visitType(int r5) {
        KmType r10 = new KmType(r5);
        setType(r10);
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor
    public KmTypeVisitor visitVarargElementType(int r5) {
        KmType r10 = new KmType(r5);
        this.varargElementType = r10;
        return r10;
    }
}
