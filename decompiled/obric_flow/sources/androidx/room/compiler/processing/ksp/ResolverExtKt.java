package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.room.compiler.processing.XExecutableElement;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.ksp.synthetic.KspSyntheticPropertyMethodElement;
import hl.d;
import il.c;
import il.g;
import il.p;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0013*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lhl/d;", "", "qName", "Lil/c;", "findClass", "(Lhl/d;Ljava/lang/String;)Lil/c;", "requireClass", "Lil/p;", "requireType", "(Lhl/d;Ljava/lang/String;)Lil/p;", "requireContinuationClass", "(Lhl/d;)Lil/c;", "Landroidx/room/compiler/processing/XExecutableElement;", "Lil/d;", "getDeclarationForOverride", "(Landroidx/room/compiler/processing/XExecutableElement;)Lil/d;", "Landroidx/room/compiler/processing/XMethodElement;", "overriderElement", "overrideeElement", "", "overrides", "(Lhl/d;Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XMethodElement;)Z", "Lil/g;", "other", "overridesInJvm", "(Lil/g;Lil/g;)Z", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ResolverExtKt {
    public static final c findClass(d r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "qName");
        r5.b();
        r5.c();
        return null;
    }

    private static final il.d getDeclarationForOverride(XExecutableElement r5) {
        if ((r5 instanceof KspExecutableElement) == false) goto L6;
        ((KspExecutableElement) r5).getDeclaration();
        return null;
    L6:
        if ((r5 instanceof KspSyntheticPropertyMethodElement) == false) goto L11;
        ((KspSyntheticPropertyMethodElement) r5).getField().getDeclaration();
        return null;
    L11:
        throw new IllegalStateException("unexpected XExecutableElement type. " + r5);
    }

    public static final boolean overrides(d r5, XMethodElement r10, XMethodElement r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "overriderElement");
        Intrinsics.checkNotNullParameter(r11, "overrideeElement");
        if (r10.getParameters().size() == r11.getParameters().size()) goto L5;
        return false;
    L5:
        getDeclarationForOverride(r10);
        getDeclarationForOverride(r11);
        if (r5.d() == false) goto L9;
        return true;
    L9:
        return false;
    }

    private static final boolean overridesInJvm(g r5, g r10) {
        Iterator r11 = r5.getParameters().iterator();
        if (r11.hasNext() == true) goto L6;
        return true;
    L6:
        j0.A(r11.next());
        throw null;
    }

    public static final c requireClass(d r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "qName");
        findClass(r5, r10);
        throw new IllegalStateException(("cannot find class " + r10).toString());
    }

    public static final c requireContinuationClass(d r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        requireClass(r5, "kotlin.coroutines.Continuation");
        return null;
    }

    public static final p requireType(d r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "qName");
        requireClass(r5, r10);
        CollectionsKt.emptyList();
        throw null;
    }
}
