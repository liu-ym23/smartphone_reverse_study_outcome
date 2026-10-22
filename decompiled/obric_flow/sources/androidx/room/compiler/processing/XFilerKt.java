package androidx.room.compiler.processing;

import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.XTypeSpec;
import androidx.room.compiler.codegen.java.JavaTypeSpec;
import androidx.room.compiler.codegen.kotlin.KotlinTypeSpec;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.ies.bullet.service.base.x;
import com.squareup.javapoet.g;
import com.squareup.javapoet.o;
import com.squareup.javapoet.z;
import com.squareup.kotlinpoet.AnnotationSpec$UseSiteTarget;
import com.squareup.kotlinpoet.b;
import com.squareup.kotlinpoet.d0;
import com.squareup.kotlinpoet.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z4.a;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\t\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/squareup/javapoet/o;", "Landroidx/room/compiler/processing/XFiler;", "generator", "Landroidx/room/compiler/processing/XFiler$Mode;", "mode", "", "writeTo", "(Lcom/squareup/javapoet/o;Landroidx/room/compiler/processing/XFiler;Landroidx/room/compiler/processing/XFiler$Mode;)V", "Lcom/squareup/kotlinpoet/i;", "(Lcom/squareup/kotlinpoet/i;Landroidx/room/compiler/processing/XFiler;Landroidx/room/compiler/processing/XFiler$Mode;)V", "Landroidx/room/compiler/codegen/XTypeSpec;", "(Landroidx/room/compiler/codegen/XTypeSpec;Landroidx/room/compiler/processing/XFiler;Landroidx/room/compiler/processing/XFiler$Mode;)V", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class XFilerKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[CodeLanguage.values().length];
            r5[CodeLanguage.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r5[CodeLanguage.KOTLIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final void writeTo(o r5, XFiler r10, XFiler.Mode r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "generator");
        Intrinsics.checkNotNullParameter(r11, "mode");
        r10.write(r5, r11);
    }

    public static /* synthetic */ void writeTo$default(o r5, XFiler r10, XFiler.Mode r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = XFiler.Mode.Isolating;
    L5:
        writeTo(r5, r10, r11);
    }

    public static final void writeTo(i r5, XFiler r10, XFiler.Mode r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "generator");
        Intrinsics.checkNotNullParameter(r11, "mode");
        r10.write(r5, r11);
    }

    public static /* synthetic */ void writeTo$default(i r5, XFiler r10, XFiler.Mode r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = XFiler.Mode.Isolating;
    L5:
        writeTo(r5, r10, r11);
    }

    public static final void writeTo(XTypeSpec r5, XFiler r10, XFiler.Mode r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "generator");
        Intrinsics.checkNotNullParameter(r11, "mode");
        if (r5.getClassName().getSimpleNames().size() != 1) goto L29;
        CodeLanguage r12 = r5.getLanguage();
        int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r13 == 1) goto L23;
        if (r13 == 2) goto L10;
        return;
    L10:
        if ((r5 instanceof KotlinTypeSpec) == false) goto L21;
        String r14 = r5.getClassName().getPackageName();
        String r15 = (String) CollectionsKt.single(r5.getClassName().getSimpleNames());
        Intrinsics.checkNotNullParameter(r14, "packageName");
        Intrinsics.checkNotNullParameter(r15, "fileName");
        x r16 = new x(r14, r15);
        d0 r17 = ((KotlinTypeSpec) r5).getActual$room_compiler_processing();
        Intrinsics.checkNotNullParameter(r17, "typeSpec");
        ((ArrayList) r16.f6025h).add(r17);
        Iterator r18 = ((ArrayList) r16.f6026i).iterator();
    L13:
        if (r18.hasNext() == false) goto L19;
        ((b) r18.next()).getClass();
        if (AnnotationSpec$UseSiteTarget.FILE == null) goto L13;
        throw new IllegalStateException("Use-site target null not supported for file annotations.");
    L19:
        writeTo(new i(r16), r10, r11);
        return;
    L21:
        throw new IllegalStateException("Check failed.");
    L23:
        if ((r5 instanceof JavaTypeSpec) == false) goto L27;
        String r19 = r5.getClassName().getPackageName();
        z r20 = ((JavaTypeSpec) r5).getActual$room_compiler_processing();
        f.s(r19, "packageName == null", new Object[0]);
        f.s(r20, "typeSpec == null", new Object[0]);
        a r21 = new a();
        int r22 = com.squareup.javapoet.i.f14970c;
        r21.f23391c = new g();
        r21.d = "  ";
        r21.e = new TreeSet();
        r21.f23389a = r19;
        r21.f23390b = r20;
        writeTo(new o(r21), r10, r11);
        return;
    L27:
        throw new IllegalStateException("Check failed.");
    L29:
        throw new IllegalArgumentException("XTypeSpec must be a top-level class.");
    }

    public static /* synthetic */ void writeTo$default(XTypeSpec r5, XFiler r10, XFiler.Mode r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = XFiler.Mode.Isolating;
    L5:
        writeTo(r5, r10, r11);
    }
}
