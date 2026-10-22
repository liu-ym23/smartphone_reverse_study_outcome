package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterExtensionVisitor;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmTypeParameterExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterExtensionVisitor;", "delegate", "<init>", "(Ljava/lang/Object;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "annotation", "", "visitAnnotation", "(Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;)V", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmTypeParameterExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "getType", "()Lzt/c;", "type", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class JvmTypeParameterExtensionVisitor implements KmTypeParameterExtensionVisitor {
    public static final Companion Companion = null;

    @JvmField
    public static final KmExtensionType TYPE = null;
    private final JvmTypeParameterExtensionVisitor delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmTypeParameterExtensionVisitor$Companion;", "", "()V", "TYPE", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmTypeParameterExtensionVisitor.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public JvmTypeParameterExtensionVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor
    public final KmExtensionType getType() {
        return TYPE;
    }

    public void visitAnnotation(KmAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        JvmTypeParameterExtensionVisitor r10 = this.delegate;
        if (r10 == null) goto L6;
        r10.visitAnnotation(r5);
        return;
    }

    public void visitEnd() {
        JvmTypeParameterExtensionVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    @JvmOverloads
    public JvmTypeParameterExtensionVisitor(JvmTypeParameterExtensionVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ JvmTypeParameterExtensionVisitor(JvmTypeParameterExtensionVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
