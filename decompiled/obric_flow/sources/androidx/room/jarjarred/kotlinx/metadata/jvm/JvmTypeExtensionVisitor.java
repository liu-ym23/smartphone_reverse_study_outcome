package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeExtensionVisitor;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmTypeExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeExtensionVisitor;", "delegate", "<init>", "(Ljava/lang/Object;)V", "", "isRaw", "", "visit", "(Z)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "annotation", "visitAnnotation", "(Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;)V", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmTypeExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "getType", "()Lzt/c;", "type", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class JvmTypeExtensionVisitor implements KmTypeExtensionVisitor {
    public static final Companion Companion = null;
    public static final String PLATFORM_TYPE_ID = "kotlin.jvm.PlatformType";

    @JvmField
    public static final KmExtensionType TYPE = null;
    private final JvmTypeExtensionVisitor delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmTypeExtensionVisitor$Companion;", "", "()V", "PLATFORM_TYPE_ID", "", "TYPE", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmTypeExtensionVisitor.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public JvmTypeExtensionVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor
    public final KmExtensionType getType() {
        return TYPE;
    }

    public void visit(boolean r5) {
        JvmTypeExtensionVisitor r10 = this.delegate;
        if (r10 == null) goto L6;
        r10.visit(r5);
        return;
    }

    public void visitAnnotation(KmAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        JvmTypeExtensionVisitor r10 = this.delegate;
        if (r10 == null) goto L6;
        r10.visitAnnotation(r5);
        return;
    }

    public void visitEnd() {
        JvmTypeExtensionVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    @JvmOverloads
    public JvmTypeExtensionVisitor(JvmTypeExtensionVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ JvmTypeExtensionVisitor(JvmTypeExtensionVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
