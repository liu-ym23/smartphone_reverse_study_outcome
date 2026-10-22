package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0004\u000f\u0010\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J;\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJK\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0000\"\b\b\u0001\u0010\u000b*\u00020\u00022(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\r0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJE\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0000\"\b\b\u0001\u0010\u000b*\u00020\u00022\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0001\u0004\u0013\u0014\u0015\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/paging/PageEvent;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "filter", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flatMap", "R", "transform", "", "map", "Drop", "Insert", "LoadStateUpdate", "StaticList", "Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/PageEvent$LoadStateUpdate;", "Landroidx/paging/PageEvent$StaticList;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PageEvent<T> {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J7\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Landroidx/paging/PageEvent$Drop;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "minPageOffset", "", "maxPageOffset", "placeholdersRemaining", "(Landroidx/paging/LoadType;III)V", "getLoadType", "()Landroidx/paging/LoadType;", "getMaxPageOffset", "()I", "getMinPageOffset", "pageCount", "getPageCount", "getPlaceholdersRemaining", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Drop<T> extends PageEvent<T> {
        private final LoadType loadType;
        private final int maxPageOffset;
        private final int minPageOffset;
        private final int placeholdersRemaining;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[LoadType.values().length];
                r0[LoadType.APPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public Drop(LoadType r2, int r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "loadType");
            super(null);
            this.loadType = r2;
            this.minPageOffset = r3;
            this.maxPageOffset = r4;
            this.placeholdersRemaining = r5;
            boolean r6 = true;
            if (r2 == LoadType.REFRESH) goto L5;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L22;
            if (getPageCount() <= 0) goto L10;
            boolean r8 = true;
        L11:
            if (r8 == false) goto L20;
            if (r5 >= 0) goto L15;
            r6 = false;
        L15:
            if (r6 == false) goto L18;
            return;
        L18:
            throw new IllegalArgumentException(("Invalid placeholdersRemaining " + r5).toString());
        L20:
            throw new IllegalArgumentException(("Drop count must be > 0, but was " + getPageCount()).toString());
        L10:
            r8 = false;
            goto L11
        L22:
            throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND".toString());
        L5:
            r7 = false;
            goto L6
        }

        public static /* synthetic */ Drop copy$default(Drop r0, LoadType r1, int r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.loadType;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.minPageOffset;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.maxPageOffset;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.placeholdersRemaining;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final LoadType component1() {
            return this.loadType;
        }

        public final int component2() {
            return this.minPageOffset;
        }

        public final int component3() {
            return this.maxPageOffset;
        }

        public final int component4() {
            return this.placeholdersRemaining;
        }

        public final Drop<T> copy(LoadType r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "loadType");
            return new Drop(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Drop.class) == true) goto L8;
            return false;
        L8:
            Drop r6 = (Drop) ZeusTransformUtils.preCheckCast(r5, Drop.class, "com.obric.memorydata.plugin");
            if (this.loadType == r6.loadType) goto L12;
            return false;
        L12:
            if (this.minPageOffset == r6.minPageOffset) goto L15;
            return false;
        L15:
            if (this.maxPageOffset == r6.maxPageOffset) goto L18;
            return false;
        L18:
            if (this.placeholdersRemaining == r6.placeholdersRemaining) goto L20;
            return false;
        L20:
            return true;
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final int getMaxPageOffset() {
            return this.maxPageOffset;
        }

        public final int getMinPageOffset() {
            return this.minPageOffset;
        }

        public final int getPageCount() {
            return (this.maxPageOffset - this.minPageOffset) + 1;
        }

        public final int getPlaceholdersRemaining() {
            return this.placeholdersRemaining;
        }

        public int hashCode() {
            return (((((this.loadType.hashCode() * 31) + Integer.hashCode(this.minPageOffset)) * 31) + Integer.hashCode(this.maxPageOffset)) * 31) + Integer.hashCode(this.placeholdersRemaining);
        }

        public String toString() {
            int r0 = WhenMappings.$EnumSwitchMapping$0[this.loadType.ordinal()];
            if (r0 != 1) goto L5;
            String r1 = "end";
        L11:
            return StringsKt.trimMargin$default("PageEvent.Drop from the " + r1 + " (\n                    |   minPageOffset: " + this.minPageOffset + "\n                    |   maxPageOffset: " + this.maxPageOffset + "\n                    |   placeholdersRemaining: " + this.placeholdersRemaining + "\n                    |)", null, 1, null);
        L5:
            if (r0 != 2) goto L8;
            r1 = CpuReportEvent.VALUE_FRONT;
            goto L11
        L8:
            throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND");
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u0000 5*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00015BG\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\rHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\rHÆ\u0003JY\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0002HÖ\u0003J;\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010%\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0'\u0012\u0006\u0012\u0004\u0018\u00010\u00020&H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010(JK\u0010)\u001a\b\u0012\u0004\u0012\u0002H*0\u0003\"\b\b\u0002\u0010**\u00020\u00022(\u0010+\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0,0'\u0012\u0006\u0012\u0004\u0018\u00010\u00020&H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010(J\t\u0010-\u001a\u00020\nHÖ\u0001JE\u0010.\u001a\b\u0012\u0004\u0012\u0002H*0\u0003\"\b\b\u0002\u0010**\u00020\u00022\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0'\u0012\u0006\u0012\u0004\u0018\u00010\u00020&H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010(J9\u0010/\u001a\b\u0012\u0004\u0012\u0002H*0\u0000\"\b\b\u0002\u0010**\u00020\u00022\u001e\u0010+\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0\b00H\u0082\bJ\b\u00101\u001a\u000202H\u0016JM\u00103\u001a\b\u0012\u0004\u0012\u0002H*0\u0000\"\b\b\u0002\u0010**\u00020\u00022*\u0010+\u001a&\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0\b0\u000700H\u0080\bø\u0001\u0001¢\u0006\u0002\b4R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u00066"}, d2 = {"Landroidx/paging/PageEvent$Insert;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersBefore", "", "placeholdersAfter", "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "getLoadType", "()Landroidx/paging/LoadType;", "getMediatorLoadStates", "()Landroidx/paging/LoadStates;", "getPages", "()Ljava/util/List;", "getPlaceholdersAfter", "()I", "getPlaceholdersBefore", "getSourceLoadStates", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "filter", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flatMap", "R", "transform", "", "hashCode", "map", "mapPages", "Lkotlin/Function1;", "toString", "", "transformPages", "transformPages$paging_common", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Insert<T> extends PageEvent<T> {
        public static final Companion Companion = null;
        private static final Insert<Object> EMPTY_REFRESH_LOCAL = null;
        private final LoadType loadType;
        private final LoadStates mediatorLoadStates;
        private final List<TransformablePage<T>> pages;
        private final int placeholdersAfter;
        private final int placeholdersBefore;
        private final LoadStates sourceLoadStates;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJF\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJN\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Landroidx/paging/PageEvent$Insert$Companion;", "", "()V", "EMPTY_REFRESH_LOCAL", "Landroidx/paging/PageEvent$Insert;", "getEMPTY_REFRESH_LOCAL", "()Landroidx/paging/PageEvent$Insert;", "Append", ExifInterface.GPS_DIRECTION_TRUE, "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersAfter", "", "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "Prepend", "placeholdersBefore", "Refresh", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public static /* synthetic */ Insert Append$default(Companion r1, List r2, int r3, LoadStates r4, LoadStates r5, int r6, Object r7) {
                List<TransformablePage<T>> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
                if ((r6 & 8) == 0) goto L6;
                r5 = null;
            L6:
                return r1.Append(r8, r3, r4, r5);
            }

            public static /* synthetic */ Insert Prepend$default(Companion r1, List r2, int r3, LoadStates r4, LoadStates r5, int r6, Object r7) {
                List<TransformablePage<T>> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
                if ((r6 & 8) == 0) goto L6;
                r5 = null;
            L6:
                return r1.Prepend(r8, r3, r4, r5);
            }

            public static /* synthetic */ Insert Refresh$default(Companion r6, List r7, int r8, int r9, LoadStates r10, LoadStates r11, int r12, Object r13) {
                List<TransformablePage<T>> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
                if ((r12 & 16) == 0) goto L6;
                r11 = null;
            L6:
                return r6.Refresh(r1, r8, r9, r10, r11);
            }

            public final <T> Insert<T> Append(List<TransformablePage<T>> r9, int r10, LoadStates r11, LoadStates r12) {
                List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "pages");
                Intrinsics.checkNotNullParameter(r11, "sourceLoadStates");
                return new Insert(LoadType.APPEND, r2, -1, r10, r11, r12, null);
            }

            public final <T> Insert<T> Prepend(List<TransformablePage<T>> r9, int r10, LoadStates r11, LoadStates r12) {
                List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "pages");
                Intrinsics.checkNotNullParameter(r11, "sourceLoadStates");
                return new Insert(LoadType.PREPEND, r2, r10, -1, r11, r12, null);
            }

            public final <T> Insert<T> Refresh(List<TransformablePage<T>> r9, int r10, int r11, LoadStates r12, LoadStates r13) {
                List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "pages");
                Intrinsics.checkNotNullParameter(r12, "sourceLoadStates");
                return new Insert(LoadType.REFRESH, r2, r10, r11, r12, r13, null);
            }

            public final Insert<Object> getEMPTY_REFRESH_LOCAL() {
                return Insert.access$getEMPTY_REFRESH_LOCAL$cp();
            }
        }

        static {
            Companion r0 = new Companion(null);
            Companion = r0;
            EMPTY_REFRESH_LOCAL = Companion.Refresh$default(r0, CollectionsKt.listOf(TransformablePage.Companion.getEMPTY_INITIAL_PAGE()), 0, 0, new LoadStates((LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"), (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getComplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"), (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getComplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin")), null, 16, null);
        }

        private Insert(LoadType r3, List<TransformablePage<T>> r4, int r5, int r6, LoadStates r7, LoadStates r8) {
            List<TransformablePage<T>> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            super(null);
            this.loadType = r3;
            this.pages = r9;
            this.placeholdersBefore = r5;
            this.placeholdersAfter = r6;
            this.sourceLoadStates = r7;
            this.mediatorLoadStates = r8;
            boolean r10 = false;
            if (r3 == LoadType.APPEND) goto L7;
            if (r5 >= 0) goto L7;
            boolean r2 = false;
        L8:
            if (r2 == false) goto L28;
            if (r3 == LoadType.PREPEND) goto L14;
            if (r6 >= 0) goto L14;
            boolean r11 = false;
        L15:
            if (r11 == false) goto L26;
            if (r3 == LoadType.REFRESH) goto L19;
        L20:
            r10 = true;
        L21:
            if (r10 == false) goto L24;
            return;
        L24:
            throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.".toString());
        L19:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        L26:
            throw new IllegalArgumentException(("Append insert defining placeholdersAfter must be > 0, but was " + r6).toString());
        L14:
            r11 = true;
            goto L15
        L28:
            throw new IllegalArgumentException(("Prepend insert defining placeholdersBefore must be > 0, but was " + r5).toString());
        L7:
            r2 = true;
            goto L8
        }

        /* synthetic */ Insert(LoadType r8, List r9, int r10, int r11, LoadStates r12, LoadStates r13, int r14, DefaultConstructorMarker r15) {
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            if ((r14 & 32) == 0) goto L5;
            r13 = null;
        L5:
            this(r8, r2, r10, r11, r12, r13);
        }

        public /* synthetic */ Insert(LoadType r8, List r9, int r10, int r11, LoadStates r12, LoadStates r13, DefaultConstructorMarker r14) {
            this(r8, (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13);
        }

        public static final /* synthetic */ Insert access$getEMPTY_REFRESH_LOCAL$cp() {
            return EMPTY_REFRESH_LOCAL;
        }

        public static /* synthetic */ Insert copy$default(Insert r7, LoadType r8, List r9, int r10, int r11, LoadStates r12, LoadStates r13, int r14, Object r15) {
            List<TransformablePage<T>> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            if ((r14 & 1) == 0) goto L5;
            r8 = r7.loadType;
        L5:
            LoadType r1 = r8;
            if ((r14 & 2) == 0) goto L8;
            r16 = r7.pages;
        L8:
            List<TransformablePage<T>> r2 = r16;
            if ((r14 & 4) == 0) goto L11;
            r10 = r7.placeholdersBefore;
        L11:
            int r3 = r10;
            if ((r14 & 8) == 0) goto L14;
            r11 = r7.placeholdersAfter;
        L14:
            int r4 = r11;
            if ((r14 & 16) == 0) goto L17;
            r12 = r7.sourceLoadStates;
        L17:
            LoadStates r5 = r12;
            if ((r14 & 32) == 0) goto L21;
            r13 = r7.mediatorLoadStates;
        L21:
            return r7.copy(r1, r2, r3, r4, r5, r13);
        }

        private final <R> Insert<R> mapPages(Function1<? super TransformablePage<T>, TransformablePage<R>> r11) {
            Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
            LoadType r3 = getLoadType();
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(getPages(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator<T> r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            r2.add(r12.invoke(r1.next()));
            goto L4
        L7:
            return new Insert(r3, (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), getPlaceholdersBefore(), getPlaceholdersAfter(), getSourceLoadStates(), getMediatorLoadStates(), null);
        }

        public final LoadType component1() {
            return this.loadType;
        }

        public final List<TransformablePage<T>> component2() {
            return this.pages;
        }

        public final int component3() {
            return this.placeholdersBefore;
        }

        public final int component4() {
            return this.placeholdersAfter;
        }

        public final LoadStates component5() {
            return this.sourceLoadStates;
        }

        public final LoadStates component6() {
            return this.mediatorLoadStates;
        }

        public final Insert<T> copy(LoadType r8, List<TransformablePage<T>> r9, int r10, int r11, LoadStates r12, LoadStates r13) {
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "loadType");
            Intrinsics.checkNotNullParameter(r2, "pages");
            Intrinsics.checkNotNullParameter(r12, "sourceLoadStates");
            return new Insert(r8, r2, r10, r11, r12, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Insert.class) == true) goto L8;
            return false;
        L8:
            Insert r6 = (Insert) ZeusTransformUtils.preCheckCast(r5, Insert.class, "com.obric.memorydata.plugin");
            if (this.loadType == r6.loadType) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.pages, r6.pages) == true) goto L15;
            return false;
        L15:
            if (this.placeholdersBefore == r6.placeholdersBefore) goto L18;
            return false;
        L18:
            if (this.placeholdersAfter == r6.placeholdersAfter) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.sourceLoadStates, r6.sourceLoadStates) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.mediatorLoadStates, r6.mediatorLoadStates) == true) goto L26;
            return false;
        L26:
            return true;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x010a -> B:18:0x014b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0182 -> B:27:0x0193). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        public Object filter(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r20, Continuation<? super PageEvent<T>> r21) {
            Function2 r0 = (Function2) ZeusTransformUtils.wrapperContextForParams(r20, Function2.class, "com.obric.memorydata.plugin");
            Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r2, PageEvent$Insert$filter$1.class) == false) goto L7;
            PageEvent$Insert$filter$1 r3 = (PageEvent$Insert$filter$1) ZeusTransformUtils.preCheckCast(r2, PageEvent$Insert$filter$1.class, "com.obric.memorydata.plugin");
            if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
            r3.label -= Integer.MIN_VALUE;
            Insert<T> r4 = this;
        L8:
            Object r5 = r3.result;
            Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r7 = r3.label;
            if (r7 == 0) goto L14;
            if (r7 != 1) goto L13;
            int r1 = r3.I$1;
            int r8 = r3.I$0;
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$10, Collection.class, "com.obric.memorydata.plugin");
            Object r10 = r3.L$9;
            Iterator<T> r11 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$8, Iterator.class, "com.obric.memorydata.plugin");
            List r12 = (List) ZeusTransformUtils.preCheckCast(r3.L$7, List.class, "com.obric.memorydata.plugin");
            List r13 = (List) ZeusTransformUtils.preCheckCast(r3.L$6, List.class, "com.obric.memorydata.plugin");
            TransformablePage r14 = (TransformablePage) ZeusTransformUtils.preCheckCast(r3.L$5, TransformablePage.class, "com.obric.memorydata.plugin");
            Iterator<T> r15 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$4, Iterator.class, "com.obric.memorydata.plugin");
            Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$3, Collection.class, "com.obric.memorydata.plugin");
            LoadType r17 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$2, LoadType.class, "com.obric.memorydata.plugin");
            Insert<T> r18 = (Insert) ZeusTransformUtils.preCheckCast(r3.L$1, Insert.class, "com.obric.memorydata.plugin");
            Function2 r19 = (Function2) ZeusTransformUtils.preCheckCast(r3.L$0, Function2.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r5);
            int r110 = r8;
            TransformablePage r111 = r14;
            PageEvent$Insert$filter$1 r22 = r3;
            List r112 = r13;
            Iterator<T> r113 = r11;
            LoadType r23 = r17;
            Collection r24 = r9;
            Object r25 = r6;
            Insert<T> r26 = r18;
            int r27 = r1;
            Function2 r114 = r19;
        L28:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L33;
            r112.add(r10);
            List<Integer> r28 = r111.getHintOriginalIndices();
            if (r28 == null) goto L32;
            r27 = ((Number) ZeusTransformUtils.preCheckCast(r28.get(r27), Number.class, "com.obric.memorydata.plugin")).intValue();
        L32:
            r12.add(Boxing.boxInt(r27));
        L33:
            Function2 r29 = r114;
            LoadType r30 = r23;
            Iterator<T> r31 = r15;
            Collection r32 = r16;
            int r33 = r110;
            TransformablePage r115 = r111;
        L19:
            if (r113.hasNext() == false) goto L34;
            T r116 = r113.next();
            r110 = r33 + 1;
            if (r33 >= 0) goto L23;
            CollectionsKt.throwIndexOverflow();
        L23:
            r22.L$0 = r29;
            r22.L$1 = r26;
            r22.L$2 = r30;
            r22.L$3 = r32;
            r22.L$4 = r31;
            r22.L$5 = r115;
            r22.L$6 = r112;
            r22.L$7 = r12;
            r22.L$8 = r113;
            r22.L$9 = r116;
            r22.L$10 = r24;
            r22.I$0 = r110;
            r22.I$1 = r33;
            int r117 = r33;
            r22.label = 1;
            Object r34 = r29.invoke(r116, r22);
            if (r34 != r25) goto L26;
            return r25;
        L26:
            r111 = r115;
            r15 = r31;
            r27 = r117;
            r114 = r29;
            r5 = r34;
            Collection r118 = r32;
            r23 = r30;
            r10 = r116;
            r16 = r118;
            goto L28
        L34:
            r24.add(new TransformablePage(r115.getOriginalPageOffsets(), r112, r115.getHintOriginalPageOffset(), r12));
            r0 = r29;
            Iterator<T> r35 = r31;
            r3 = r22;
            r4 = r26;
            r6 = r25;
            LoadType r36 = r30;
            r24 = r32;
        L16:
            if (r35.hasNext() == false) goto L36;
            TransformablePage r37 = (TransformablePage) ZeusTransformUtils.preCheckCast(r35.next(), TransformablePage.class, "com.obric.memorydata.plugin");
            List r38 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r113 = ((Iterable) ZeusTransformUtils.preCheckCast(r37.getData(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            r115 = r37;
            r30 = r36;
            r25 = r6;
            r26 = r4;
            r22 = r3;
            r31 = r35;
            r29 = r0;
            r33 = 0;
            r112 = r38;
            r32 = r24;
            goto L19
        L36:
            return new Insert(r36, (List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin"), r4.getPlaceholdersBefore(), r4.getPlaceholdersAfter(), r4.getSourceLoadStates(), r4.getMediatorLoadStates(), null);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r5);
            LoadType r39 = getLoadType();
            Iterable r40 = (Iterable) ZeusTransformUtils.preCheckCast(getPages(), Iterable.class, "com.obric.memorydata.plugin");
            r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator<T> r41 = r40.iterator();
            r36 = r39;
            r35 = r41;
        L7:
            r4 = this;
            r3 = new PageEvent$Insert$filter$1(r4, r2);
            goto L8
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0112 -> B:18:0x0153). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0196 -> B:27:0x01a2). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        public <R> Object flatMap(Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> r19, Continuation<? super PageEvent<R>> r20) {
            Function2 r0 = (Function2) ZeusTransformUtils.wrapperContextForParams(r19, Function2.class, "com.obric.memorydata.plugin");
            Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r2, PageEvent$Insert$flatMap$1.class) == false) goto L7;
            PageEvent$Insert$flatMap$1 r3 = (PageEvent$Insert$flatMap$1) ZeusTransformUtils.preCheckCast(r2, PageEvent$Insert$flatMap$1.class, "com.obric.memorydata.plugin");
            if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
            r3.label -= Integer.MIN_VALUE;
            Insert<T> r4 = this;
        L8:
            Object r5 = r3.result;
            Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r7 = r3.label;
            if (r7 == 0) goto L14;
            if (r7 != 1) goto L13;
            int r1 = r3.I$1;
            int r8 = r3.I$0;
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$10, Collection.class, "com.obric.memorydata.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$9, Collection.class, "com.obric.memorydata.plugin");
            Iterator<T> r11 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$8, Iterator.class, "com.obric.memorydata.plugin");
            List r12 = (List) ZeusTransformUtils.preCheckCast(r3.L$7, List.class, "com.obric.memorydata.plugin");
            List r13 = (List) ZeusTransformUtils.preCheckCast(r3.L$6, List.class, "com.obric.memorydata.plugin");
            TransformablePage r14 = (TransformablePage) ZeusTransformUtils.preCheckCast(r3.L$5, TransformablePage.class, "com.obric.memorydata.plugin");
            Iterator<T> r15 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$4, Iterator.class, "com.obric.memorydata.plugin");
            Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$3, Collection.class, "com.obric.memorydata.plugin");
            LoadType r17 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$2, LoadType.class, "com.obric.memorydata.plugin");
            Insert<T> r18 = (Insert) ZeusTransformUtils.preCheckCast(r3.L$1, Insert.class, "com.obric.memorydata.plugin");
            Function2 r21 = (Function2) ZeusTransformUtils.preCheckCast(r3.L$0, Function2.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r5);
            int r110 = r8;
            TransformablePage r111 = r14;
            PageEvent$Insert$flatMap$1 r22 = r3;
            List r112 = r13;
            Iterator<T> r113 = r11;
            LoadType r23 = r17;
            Collection r24 = r9;
            Object r25 = r6;
            Insert<T> r26 = r18;
            int r27 = r1;
            Function2 r114 = r21;
        L27:
            CollectionsKt.addAll(r10, (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"));
            List<Integer> r28 = r111.getHintOriginalIndices();
            if (r28 == null) goto L31;
            r27 = ((Number) ZeusTransformUtils.preCheckCast(r28.get(r27), Number.class, "com.obric.memorydata.plugin")).intValue();
        L31:
            if (r12.size() >= r112.size()) goto L33;
            r12.add(Boxing.boxInt(r27));
            goto L31
        L33:
            Function2 r29 = r114;
            LoadType r30 = r23;
            Iterator<T> r31 = r15;
            Collection r32 = r16;
            int r33 = r110;
            TransformablePage r115 = r111;
        L19:
            if (r113.hasNext() == false) goto L34;
            T r116 = r113.next();
            r110 = r33 + 1;
            if (r33 >= 0) goto L23;
            CollectionsKt.throwIndexOverflow();
        L23:
            Object r117 = r25;
            Collection r34 = (Collection) ZeusTransformUtils.preCheckCast(r112, Collection.class, "com.obric.memorydata.plugin");
            r22.L$0 = r29;
            r22.L$1 = r26;
            r22.L$2 = r30;
            r22.L$3 = r32;
            r22.L$4 = r31;
            r22.L$5 = r115;
            r22.L$6 = r112;
            r22.L$7 = r12;
            r22.L$8 = r113;
            r22.L$9 = r34;
            r22.L$10 = r24;
            r22.I$0 = r110;
            r22.I$1 = r33;
            int r210 = r33;
            r22.label = 1;
            Object r118 = r29.invoke(r116, r22);
            if (r118 != r117) goto L26;
            return r117;
        L26:
            r114 = r29;
            r111 = r115;
            r5 = r118;
            r15 = r31;
            r16 = r32;
            r23 = r30;
            r10 = r34;
            r25 = r117;
            r27 = r210;
            goto L27
        L34:
            Object r35 = r25;
            r24.add(new TransformablePage(r115.getOriginalPageOffsets(), r112, r115.getHintOriginalPageOffset(), r12));
            LoadType r36 = r30;
            r24 = r32;
            Insert<T> r119 = r26;
            r6 = r35;
            r0 = r29;
            Iterator<T> r37 = r31;
            r3 = r22;
            r4 = r119;
        L16:
            if (r37.hasNext() == false) goto L36;
            TransformablePage r38 = (TransformablePage) ZeusTransformUtils.preCheckCast(r37.next(), TransformablePage.class, "com.obric.memorydata.plugin");
            List r39 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r113 = ((Iterable) ZeusTransformUtils.preCheckCast(r38.getData(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            r115 = r38;
            r30 = r36;
            r25 = r6;
            r26 = r4;
            r22 = r3;
            r31 = r37;
            r29 = r0;
            r33 = 0;
            r112 = r39;
            r32 = r24;
            goto L19
        L36:
            return new Insert(r36, (List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin"), r4.getPlaceholdersBefore(), r4.getPlaceholdersAfter(), r4.getSourceLoadStates(), r4.getMediatorLoadStates(), null);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r5);
            LoadType r40 = getLoadType();
            Iterable r41 = (Iterable) ZeusTransformUtils.preCheckCast(getPages(), Iterable.class, "com.obric.memorydata.plugin");
            r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r41, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator<T> r42 = r41.iterator();
            r36 = r40;
            r37 = r42;
        L7:
            r4 = this;
            r3 = new PageEvent$Insert$flatMap$1(r4, r2);
            goto L8
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final LoadStates getMediatorLoadStates() {
            return this.mediatorLoadStates;
        }

        public final List<TransformablePage<T>> getPages() {
            return this.pages;
        }

        public final int getPlaceholdersAfter() {
            return this.placeholdersAfter;
        }

        public final int getPlaceholdersBefore() {
            return this.placeholdersBefore;
        }

        public final LoadStates getSourceLoadStates() {
            return this.sourceLoadStates;
        }

        public int hashCode() {
            int r0 = ((((((((this.loadType.hashCode() * 31) + this.pages.hashCode()) * 31) + Integer.hashCode(this.placeholdersBefore)) * 31) + Integer.hashCode(this.placeholdersAfter)) * 31) + this.sourceLoadStates.hashCode()) * 31;
            LoadStates r2 = this.mediatorLoadStates;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0104 -> B:18:0x0140). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x016a -> B:24:0x0176). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        public <R> Object map(Function2<? super T, ? super Continuation<? super R>, ? extends Object> r19, Continuation<? super PageEvent<R>> r20) {
            Function2 r0 = (Function2) ZeusTransformUtils.wrapperContextForParams(r19, Function2.class, "com.obric.memorydata.plugin");
            Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r2, PageEvent$Insert$map$1.class) == false) goto L7;
            PageEvent$Insert$map$1 r3 = (PageEvent$Insert$map$1) ZeusTransformUtils.preCheckCast(r2, PageEvent$Insert$map$1.class, "com.obric.memorydata.plugin");
            if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
            r3.label -= Integer.MIN_VALUE;
            Insert<T> r4 = this;
        L8:
            Object r5 = r3.result;
            Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r7 = r3.label;
            if (r7 == 0) goto L14;
            if (r7 != 1) goto L13;
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$10, Collection.class, "com.obric.memorydata.plugin");
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$9, Collection.class, "com.obric.memorydata.plugin");
            Iterator<T> r9 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$8, Iterator.class, "com.obric.memorydata.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$7, Collection.class, "com.obric.memorydata.plugin");
            int[] r11 = (int[]) ZeusTransformUtils.preCheckCast(r3.L$6, int[].class, "com.obric.memorydata.plugin");
            TransformablePage r12 = (TransformablePage) ZeusTransformUtils.preCheckCast(r3.L$5, TransformablePage.class, "com.obric.memorydata.plugin");
            Iterator<T> r13 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$4, Iterator.class, "com.obric.memorydata.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$3, Collection.class, "com.obric.memorydata.plugin");
            LoadType r15 = (LoadType) ZeusTransformUtils.preCheckCast(r3.L$2, LoadType.class, "com.obric.memorydata.plugin");
            Insert<T> r16 = (Insert) ZeusTransformUtils.preCheckCast(r3.L$1, Insert.class, "com.obric.memorydata.plugin");
            Function2 r17 = (Function2) ZeusTransformUtils.preCheckCast(r3.L$0, Function2.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r5);
            TransformablePage r18 = r12;
            Collection r110 = r10;
            int[] r21 = r11;
            Iterator<T> r111 = r9;
            Object r22 = r6;
            PageEvent$Insert$map$1 r23 = r3;
            Iterator<T> r24 = r13;
        L24:
            r8.add(r5);
            PageEvent$Insert$map$1 r25 = r23;
            Function2 r26 = r17;
            Insert<T> r27 = r16;
            Collection r28 = r14;
            LoadType r29 = r15;
            TransformablePage r112 = r18;
        L19:
            if (r111.hasNext() == false) goto L25;
            T r113 = r111.next();
            r25.L$0 = r26;
            r25.L$1 = r27;
            r25.L$2 = r29;
            r25.L$3 = r28;
            r25.L$4 = r24;
            r25.L$5 = r112;
            r25.L$6 = r21;
            r25.L$7 = r110;
            r25.L$8 = r111;
            r25.L$9 = r110;
            r25.L$10 = r1;
            r25.label = 1;
            Object r114 = r26.invoke(r113, r25);
            if (r114 != r22) goto L23;
            return r22;
        L23:
            r18 = r112;
            r14 = r28;
            r16 = r27;
            r23 = r25;
            r8 = r110;
            LoadType r115 = r29;
            r17 = r26;
            r5 = r114;
            r15 = r115;
            goto L24
        L25:
            r1.add(new TransformablePage(r21, (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin"), r112.getHintOriginalPageOffset(), r112.getHintOriginalIndices()));
            r0 = r26;
            Iterator<T> r30 = r24;
            r3 = r25;
            r4 = r27;
            r6 = r22;
            LoadType r31 = r29;
            Collection r32 = r28;
        L16:
            if (r30.hasNext() == false) goto L27;
            TransformablePage r33 = (TransformablePage) ZeusTransformUtils.preCheckCast(r30.next(), TransformablePage.class, "com.obric.memorydata.plugin");
            r21 = r33.getOriginalPageOffsets();
            Iterable r116 = (Iterable) ZeusTransformUtils.preCheckCast(r33.getData(), Iterable.class, "com.obric.memorydata.plugin");
            r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10)), Collection.class, "com.obric.memorydata.plugin");
            r111 = r116.iterator();
            r112 = r33;
            r28 = r32;
            r29 = r31;
            r22 = r6;
            r27 = r4;
            r25 = r3;
            r24 = r30;
            r26 = r0;
            r1 = r28;
            goto L19
        L27:
            return new Insert(r31, (List) ZeusTransformUtils.preCheckCast(r32, List.class, "com.obric.memorydata.plugin"), r4.getPlaceholdersBefore(), r4.getPlaceholdersAfter(), r4.getSourceLoadStates(), r4.getMediatorLoadStates(), null);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r5);
            LoadType r34 = getLoadType();
            Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(getPages(), Iterable.class, "com.obric.memorydata.plugin");
            r32 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator<T> r36 = r35.iterator();
            r31 = r34;
            r30 = r36;
        L7:
            r4 = this;
            r3 = new PageEvent$Insert$map$1(r4, r2);
            goto L8
        }

        public String toString() {
            Iterator<T> r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            int r1 = 0;
        L4:
            if (r0.hasNext() == false) goto L6;
            r1 = r1 + ((TransformablePage) ZeusTransformUtils.preCheckCast(r0.next(), TransformablePage.class, "com.obric.memorydata.plugin")).getData().size();
            goto L4
        L6:
            int r2 = this.placeholdersBefore;
            String r3 = "none";
            if (r2 == (-1)) goto L9;
            String r4 = String.valueOf(r2);
        L10:
            int r5 = this.placeholdersAfter;
            if (r5 == (-1)) goto L13;
            r3 = String.valueOf(r5);
        L13:
            LoadStates r6 = this.mediatorLoadStates;
            StringBuilder r7 = new StringBuilder().append("PageEvent.Insert for ").append(this.loadType).append(", with ").append(r1).append(" items (\n                    |   first item: ");
            TransformablePage r8 = (TransformablePage) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(this.pages), TransformablePage.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L18;
            List<T> r9 = r8.getData();
            if (r9 == null) goto L18;
            Object r10 = CollectionsKt.firstOrNull(r9);
        L19:
            StringBuilder r11 = r7.append(r10).append("\n                    |   last item: ");
            TransformablePage r12 = (TransformablePage) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(this.pages), TransformablePage.class, "com.obric.memorydata.plugin");
            if (r12 == null) goto L24;
            List<T> r13 = r12.getData();
            if (r13 == null) goto L24;
            Object r14 = CollectionsKt.lastOrNull(r13);
        L25:
            String r15 = r11.append(r14).append("\n                    |   placeholdersBefore: ").append(r4).append("\n                    |   placeholdersAfter: ").append(r3).append("\n                    |   sourceLoadStates: ").append(this.sourceLoadStates).append("\n                    ").toString();
            if (r6 == null) goto L29;
            r15 = r15 + "|   mediatorLoadStates: " + r6 + '\n';
        L29:
            return StringsKt.trimMargin$default(r15 + "|)", null, 1, null);
        L24:
            r14 = null;
        L18:
            r10 = null;
            goto L19
        L9:
            r4 = "none";
            goto L10
        }

        public final <R> Insert<R> transformPages$paging_common(Function1<? super List<TransformablePage<T>>, ? extends List<TransformablePage<R>>> r11) {
            Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "transform");
            return new Insert(getLoadType(), (List) ZeusTransformUtils.preCheckCast(r12.invoke(getPages()), List.class, "com.obric.memorydata.plugin"), getPlaceholdersBefore(), getPlaceholdersAfter(), getSourceLoadStates(), getMediatorLoadStates(), null);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J%\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/paging/PageEvent$LoadStateUpdate;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PageEvent;", AILabCheckPermissionTask.KEY_SOURCE, "Landroidx/paging/LoadStates;", "mediator", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "getMediator", "()Landroidx/paging/LoadStates;", "getSource", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LoadStateUpdate<T> extends PageEvent<T> {
        private final LoadStates mediator;
        private final LoadStates source;

        public LoadStateUpdate(LoadStates r2, LoadStates r3) {
            Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
            super(null);
            this.source = r2;
            this.mediator = r3;
        }

        public /* synthetic */ LoadStateUpdate(LoadStates r1, LoadStates r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public static /* synthetic */ LoadStateUpdate copy$default(LoadStateUpdate r0, LoadStates r1, LoadStates r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.source;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.mediator;
        L9:
            return r0.copy(r1, r2);
        }

        public final LoadStates component1() {
            return this.source;
        }

        public final LoadStates component2() {
            return this.mediator;
        }

        public final LoadStateUpdate<T> copy(LoadStates r1, LoadStates r2) {
            Intrinsics.checkNotNullParameter(r1, AILabCheckPermissionTask.KEY_SOURCE);
            return new LoadStateUpdate(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, LoadStateUpdate.class) == true) goto L8;
            return false;
        L8:
            LoadStateUpdate r6 = (LoadStateUpdate) ZeusTransformUtils.preCheckCast(r5, LoadStateUpdate.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.source, r6.source) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.mediator, r6.mediator) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final LoadStates getMediator() {
            return this.mediator;
        }

        public final LoadStates getSource() {
            return this.source;
        }

        public int hashCode() {
            int r0 = this.source.hashCode() * 31;
            LoadStates r1 = this.mediator;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            LoadStates r0 = this.mediator;
            String r3 = "PageEvent.LoadStateUpdate (\n                    |   sourceLoadStates: " + this.source + "\n                    ";
            if (r0 == null) goto L6;
            r3 = r3 + "|   mediatorLoadStates: " + r0 + '\n';
        L6:
            return StringsKt.trimMargin$default(r3 + "|)", null, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003J;\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJK\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0003\"\b\b\u0002\u0010\u001c*\u00020\u00022(\u0010\u001d\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001e0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\t\u0010\u001f\u001a\u00020 HÖ\u0001JE\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0003\"\b\b\u0002\u0010\u001c*\u00020\u00022\"\u0010\u001d\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\b\u0010\"\u001a\u00020#H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Landroidx/paging/PageEvent$StaticList;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PageEvent;", "data", "", "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "(Ljava/util/List;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "getData", "()Ljava/util/List;", "getMediatorLoadStates", "()Landroidx/paging/LoadStates;", "getSourceLoadStates", "component1", "component2", "component3", "copy", "equals", "", "other", "filter", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flatMap", "R", "transform", "", "hashCode", "", "map", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StaticList<T> extends PageEvent<T> {
        private final List<T> data;
        private final LoadStates mediatorLoadStates;
        private final LoadStates sourceLoadStates;

        public StaticList(List<? extends T> r3, LoadStates r4, LoadStates r5) {
            List<T> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "data");
            super(null);
            this.data = r6;
            this.sourceLoadStates = r4;
            this.mediatorLoadStates = r5;
        }

        public /* synthetic */ StaticList(List r2, LoadStates r3, LoadStates r4, int r5, DefaultConstructorMarker r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            this(r7, r3, r4);
        }

        public static /* synthetic */ StaticList copy$default(StaticList r1, List r2, LoadStates r3, LoadStates r4, int r5, Object r6) {
            List<T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            if ((r5 & 1) == 0) goto L6;
            r7 = r1.data;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = r1.sourceLoadStates;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r1.mediatorLoadStates;
        L12:
            return r1.copy(r7, r3, r4);
        }

        public final List<T> component1() {
            return this.data;
        }

        public final LoadStates component2() {
            return this.sourceLoadStates;
        }

        public final LoadStates component3() {
            return this.mediatorLoadStates;
        }

        public final StaticList<T> copy(List<? extends T> r2, LoadStates r3, LoadStates r4) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "data");
            return new StaticList(r1, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, StaticList.class) == true) goto L8;
            return false;
        L8:
            StaticList r6 = (StaticList) ZeusTransformUtils.preCheckCast(r5, StaticList.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.data, r6.data) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sourceLoadStates, r6.sourceLoadStates) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.mediatorLoadStates, r6.mediatorLoadStates) == true) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00b5 -> B:21:0x00ba). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        public Object filter(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r10, Continuation<? super PageEvent<T>> r11) {
            Function2 r12 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
            Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r13, PageEvent$StaticList$filter$1.class) == false) goto L7;
            PageEvent$StaticList$filter$1 r0 = (PageEvent$StaticList$filter$1) ZeusTransformUtils.preCheckCast(r13, PageEvent$StaticList$filter$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r14 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Object r9 = r0.L$4;
            Iterator<T> r15 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$3, Iterator.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$2, Collection.class, "com.obric.memorydata.plugin");
            Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(r0.L$1, Function2.class, "com.obric.memorydata.plugin");
            StaticList<T> r6 = (StaticList) ZeusTransformUtils.preCheckCast(r0.L$0, StaticList.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);
        L22:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L24;
            r4.add(r9);
        L24:
            Function2 r16 = r5;
            StaticList<T> this = r6;
        L16:
            if (r15.hasNext() == false) goto L26;
            T r7 = r15.next();
            r0.L$0 = this;
            r0.L$1 = r16;
            r0.L$2 = r4;
            r0.L$3 = r15;
            r0.L$4 = r7;
            r0.label = 1;
            Object r8 = r16.invoke(r7, r0);
            if (r8 != r2) goto L20;
            return r2;
        L20:
            r6 = this;
            r9 = r7;
            r5 = r16;
            r14 = r8;
            goto L22
        L26:
            return new StaticList((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), this.sourceLoadStates, this.mediatorLoadStates);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(this.data, Iterable.class, "com.obric.memorydata.plugin");
            r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator<T> r18 = r17.iterator();
            r16 = r12;
            r15 = r18;
        L7:
            r0 = new PageEvent$StaticList$filter$1(this, r13);
            goto L8
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00b5 -> B:21:0x00b9). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        public <R> Object flatMap(Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> r9, Continuation<? super PageEvent<R>> r10) {
            Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, PageEvent$StaticList$flatMap$1.class) == false) goto L7;
            PageEvent$StaticList$flatMap$1 r0 = (PageEvent$StaticList$flatMap$1) ZeusTransformUtils.preCheckCast(r12, PageEvent$StaticList$flatMap$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r13 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Iterator<T> r8 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$3, Iterator.class, "com.obric.memorydata.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$2, Collection.class, "com.obric.memorydata.plugin");
            Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(r0.L$1, Function2.class, "com.obric.memorydata.plugin");
            StaticList<T> r5 = (StaticList) ZeusTransformUtils.preCheckCast(r0.L$0, StaticList.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
            Collection r6 = r14;
            StaticList<T> r15 = r5;
        L21:
            CollectionsKt.addAll(r6, (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"));
            Function2 r16 = r4;
            Collection r7 = r6;
        L16:
            if (r8.hasNext() == false) goto L23;
            T r17 = r8.next();
            r0.L$0 = r15;
            r0.L$1 = r16;
            r0.L$2 = r7;
            r0.L$3 = r8;
            r0.label = 1;
            Object r18 = r16.invoke(r17, r0);
            if (r18 != r2) goto L20;
            return r2;
        L20:
            Collection r19 = r7;
            r4 = r16;
            r13 = r18;
            r6 = r19;
            goto L21
        L23:
            return new StaticList((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), r15.sourceLoadStates, r15.mediatorLoadStates);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r13);
            Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(this.data, Iterable.class, "com.obric.memorydata.plugin");
            r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            r15 = this;
            r8 = r110.iterator();
            r16 = r11;
        L7:
            r0 = new PageEvent$StaticList$flatMap$1(this, r12);
            goto L8
        }

        public final List<T> getData() {
            return this.data;
        }

        public final LoadStates getMediatorLoadStates() {
            return this.mediatorLoadStates;
        }

        public final LoadStates getSourceLoadStates() {
            return this.sourceLoadStates;
        }

        public int hashCode() {
            int r0 = this.data.hashCode() * 31;
            LoadStates r1 = this.sourceLoadStates;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            LoadStates r5 = this.mediatorLoadStates;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00cb -> B:21:0x00d1). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        public <R> Object map(Function2<? super T, ? super Continuation<? super R>, ? extends Object> r10, Continuation<? super PageEvent<R>> r11) {
            Function2 r12 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
            Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r13, PageEvent$StaticList$map$1.class) == false) goto L7;
            PageEvent$StaticList$map$1 r0 = (PageEvent$StaticList$map$1) ZeusTransformUtils.preCheckCast(r13, PageEvent$StaticList$map$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r14 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$4, Collection.class, "com.obric.memorydata.plugin");
            Iterator<T> r15 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$3, Iterator.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$2, Collection.class, "com.obric.memorydata.plugin");
            Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(r0.L$1, Function2.class, "com.obric.memorydata.plugin");
            StaticList<T> r6 = (StaticList) ZeusTransformUtils.preCheckCast(r0.L$0, StaticList.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);
            PageEvent$StaticList$map$1 r8 = r0;
            Iterator<T> r1 = r15;
            StaticList<T> r16 = r6;
            Object r7 = r2;
            PageEvent$StaticList$map$1 r17 = r8;
        L21:
            r9.add(r14);
            Iterator<T> r18 = r1;
            r9 = r4;
            Function2 r19 = r5;
            Object r20 = r7;
        L16:
            if (r18.hasNext() == false) goto L23;
            T r21 = r18.next();
            r17.L$0 = r16;
            r17.L$1 = r19;
            r17.L$2 = r9;
            r17.L$3 = r18;
            r17.L$4 = r9;
            r17.label = 1;
            Object r22 = r19.invoke(r21, r17);
            if (r22 != r20) goto L20;
            return r20;
        L20:
            r7 = r20;
            r4 = r9;
            Function2 r23 = r19;
            r1 = r18;
            r14 = r22;
            r5 = r23;
            goto L21
        L23:
            return new StaticList((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), r16.sourceLoadStates, r16.mediatorLoadStates);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(this.data, Iterable.class, "com.obric.memorydata.plugin");
            Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10)), Collection.class, "com.obric.memorydata.plugin");
            r18 = r110.iterator();
            r16 = this;
            r9 = r24;
            r20 = r2;
            r17 = r0;
            r19 = r12;
        L7:
            r0 = new PageEvent$StaticList$map$1(this, r13);
            goto L8
        }

        public String toString() {
            LoadStates r0 = this.mediatorLoadStates;
            String r3 = "PageEvent.StaticList with " + this.data.size() + " items (\n                    |   first item: " + CollectionsKt.firstOrNull(this.data) + "\n                    |   last item: " + CollectionsKt.lastOrNull(this.data) + "\n                    |   sourceLoadStates: " + this.sourceLoadStates + "\n                    ";
            if (r0 == null) goto L6;
            r3 = r3 + "|   mediatorLoadStates: " + r0 + '\n';
        L6:
            return StringsKt.trimMargin$default(r3 + "|)", null, 1, null);
        }
    }

    private PageEvent() {
    }

    public /* synthetic */ PageEvent(DefaultConstructorMarker r1) {
        this();
    }

    static /* synthetic */ <T> Object filter$suspendImpl(PageEvent<T> r2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3, Continuation<? super PageEvent<T>> r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return r2;
    }

    static /* synthetic */ <T, R> Object flatMap$suspendImpl(PageEvent<T> r2, Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> r3, Continuation<? super PageEvent<R>> r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.PageEvent.flatMap>");
        return r2;
    }

    static /* synthetic */ <T, R> Object map$suspendImpl(PageEvent<T> r2, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r3, Continuation<? super PageEvent<R>> r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.PageEvent.map>");
        return r2;
    }

    public Object filter(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3, Continuation<? super PageEvent<T>> r4) {
        return filter$suspendImpl(this, (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public <R> Object flatMap(Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> r3, Continuation<? super PageEvent<R>> r4) {
        return flatMap$suspendImpl(this, (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public <R> Object map(Function2<? super T, ? super Continuation<? super R>, ? extends Object> r3, Continuation<? super PageEvent<R>> r4) {
        return map$suspendImpl(this, (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
