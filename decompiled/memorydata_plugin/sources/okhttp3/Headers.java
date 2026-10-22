package okhttp3;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 '2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002&'B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001b\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0019H\u0096\u0002J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!J\b\u0010#\u001a\u00020\u0003H\u0016J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010\u0012\u001a\u00020\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006("}, d2 = {"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "namesAndValues", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "size", "", "()I", "byteCount", "", "equals", "", "other", "", "get", ActivityLifecycle.NAME, "getDate", "Ljava/util/Date;", "getInstant", "Ljava/time/Instant;", "hashCode", "iterator", "", "index", "names", "", "newBuilder", "Lokhttp3/Headers$Builder;", "-deprecated_size", "toMultimap", "", "", "toString", EventBody.KEY_VALUE, "values", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    public static final Companion Companion = null;
    private final String[] namesAndValues;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rJ\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0010J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rH\u0086\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokhttp3/Headers$Builder;", "", "()V", "namesAndValues", "", "", "getNamesAndValues$okhttp", "()Ljava/util/List;", "add", "line", ActivityLifecycle.NAME, EventBody.KEY_VALUE, "Ljava/time/Instant;", "Ljava/util/Date;", "addAll", "headers", "Lokhttp3/Headers;", "addLenient", "addLenient$okhttp", "addUnsafeNonAscii", "build", "get", "removeAll", "set", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        private final List<String> namesAndValues;

        public Builder() {
            this.namesAndValues = (List) ZeusTransformUtils.preCheckCast(new ArrayList(20), List.class, "com.obric.memorydata.plugin");
        }

        public final Builder add(String r11) {
            Intrinsics.checkParameterIsNotNull(r11, "line");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            int r3 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), ':', 0, false, 6, null);
            if (r3 == (-1)) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L14;
            String r5 = r11.substring(0, r3);
            Intrinsics.checkExpressionValueIsNotNull(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (r5 == null) goto L12;
            String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            String r12 = r11.substring(r3 + 1);
            Intrinsics.checkExpressionValueIsNotNull(r12, "(this as java.lang.String).substring(startIndex)");
            r2.add(r7, r12);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L12:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        L14:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("Unexpected header: " + r11).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r6 = false;
            goto L6
        }

        public final Builder add(String r5, String r6) {
            Intrinsics.checkParameterIsNotNull(r5, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r6, EventBody.KEY_VALUE);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            Companion.access$checkName(Headers.Companion, r5);
            Companion.access$checkValue(Headers.Companion, r6, r5);
            r2.addLenient$okhttp(r5, r6);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder add(String r7, Instant r8) {
            Intrinsics.checkParameterIsNotNull(r7, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r8, EventBody.KEY_VALUE);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).add(r7, new Date(r8.toEpochMilli()));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder add(String r4, Date r5) {
            Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r5, EventBody.KEY_VALUE);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).add(r4, DatesKt.toHttpDateString(r5));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addAll(Headers r8) {
            Intrinsics.checkParameterIsNotNull(r8, "headers");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            int r3 = r8.size();
            int r4 = 0;
        L3:
            if (r4 >= r3) goto L6;
            r2.addLenient$okhttp(r8.name(r4), r8.value(r4));
            r4 = r4 + 1;
            goto L3
        L6:
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addLenient$okhttp(String r11) {
            Intrinsics.checkParameterIsNotNull(r11, "line");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            int r3 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), ':', 1, false, 4, null);
            if (r3 == (-1)) goto L6;
            String r6 = r11.substring(0, r3);
            Intrinsics.checkExpressionValueIsNotNull(r6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String r12 = r11.substring(r3 + 1);
            Intrinsics.checkExpressionValueIsNotNull(r12, "(this as java.lang.String).substring(startIndex)");
            r2.addLenient$okhttp(r6, r12);
        L10:
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L6:
            if (r11.charAt(0) != ':') goto L8;
            r11 = r11.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(r11, "(this as java.lang.String).substring(startIndex)");
        L8:
            r2.addLenient$okhttp("", r11);
            goto L10
        }

        public final Builder addLenient$okhttp(String r5, String r6) {
            Intrinsics.checkParameterIsNotNull(r5, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r6, EventBody.KEY_VALUE);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.namesAndValues.add(r5);
            r2.namesAndValues.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString());
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addUnsafeNonAscii(String r5, String r6) {
            Intrinsics.checkParameterIsNotNull(r5, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r6, EventBody.KEY_VALUE);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            Companion.access$checkName(Headers.Companion, r5);
            r2.addLenient$okhttp(r5, r6);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Headers build() {
            Object[] r2 = ((Collection) ZeusTransformUtils.preCheckCast(this.namesAndValues, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
            if (r2 == null) goto L7;
            return new Headers((String[]) ZeusTransformUtils.preCheckCast(r2, String[].class, "com.obric.memorydata.plugin"), null);
        L7:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final String get(String r7) {
            Intrinsics.checkParameterIsNotNull(r7, ActivityLifecycle.NAME);
            IntProgression r0 = RangesKt.step(RangesKt.downTo(this.namesAndValues.size() - 2, 0), 2);
            int r1 = r0.getFirst();
            int r2 = r0.getLast();
            int r3 = r0.getStep();
            if (r3 < 0) goto L6;
            if (r1 <= r2) goto L8;
            return null;
        L8:
            if (StringsKt.equals(r7, (String) ZeusTransformUtils.preCheckCast(this.namesAndValues.get(r1), String.class, "com.obric.memorydata.plugin"), true) == true) goto L10;
            if (r1 == r2) goto L19;
            r1 = r1 + r3;
            goto L8
        L19:
            return null;
        L10:
            return (String) ZeusTransformUtils.preCheckCast(this.namesAndValues.get(r1 + 1), String.class, "com.obric.memorydata.plugin");
        L6:
            if (r1 >= r2) goto L8;
            return null;
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String r7) {
            Intrinsics.checkParameterIsNotNull(r7, ActivityLifecycle.NAME);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            int r3 = 0;
        L4:
            if (r3 >= r2.namesAndValues.size()) goto L10;
            if (StringsKt.equals(r7, (String) ZeusTransformUtils.preCheckCast(r2.namesAndValues.get(r3), String.class, "com.obric.memorydata.plugin"), true) == false) goto L8;
            r2.namesAndValues.remove(r3);
            r2.namesAndValues.remove(r3);
            r3 = r3 - 2;
        L8:
            r3 = r3 + 2;
            goto L4
        L10:
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder set(String r5, String r6) {
            Intrinsics.checkParameterIsNotNull(r5, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r6, EventBody.KEY_VALUE);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            Companion.access$checkName(Headers.Companion, r5);
            Companion.access$checkValue(Headers.Companion, r6, r5);
            r2.removeAll(r5);
            r2.addLenient$okhttp(r5, r6);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder set(String r4, Instant r5) {
            Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r5, EventBody.KEY_VALUE);
            return ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).set(r4, new Date(r5.toEpochMilli()));
        }

        public final Builder set(String r4, Date r5) {
            Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r5, EventBody.KEY_VALUE);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).set(r4, DatesKt.toHttpDateString(r5));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J%\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\b\u0011J\u001d\u0010\u0014\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\b\u000f¨\u0006\u0015"}, d2 = {"Lokhttp3/Headers$Companion;", "", "()V", "checkName", "", ActivityLifecycle.NAME, "", "checkValue", EventBody.KEY_VALUE, "get", "namesAndValues", "", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "headersOf", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "-deprecated_of", "headers", "", "toHeaders", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ void access$checkName(Companion r0, String r1) {
            r0.checkName(r1);
        }

        public static final /* synthetic */ void access$checkValue(Companion r0, String r1, String r2) {
            r0.checkValue(r1, r2);
        }

        public static final /* synthetic */ String access$get(Companion r0, String[] r1, String r2) {
            return r0.get(r1, r2);
        }

        private final void checkName(String r8) {
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L21;
            int r9 = r8.length();
            int r3 = 0;
        L8:
            if (r3 >= r9) goto L19;
            char r4 = r8.charAt(r3);
            if ('!' > r4) goto L14;
            if ('~' < r4) goto L14;
            boolean r5 = true;
        L15:
            if (r5 == false) goto L18;
            r3 = r3 + 1;
            goto L8
        L18:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r4), Integer.valueOf(r3), r8}).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L14:
            r5 = false;
            goto L15
        L19:
            return;
        L21:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("name is empty".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r7 = false;
            goto L6
        }

        private final void checkValue(String r7, String r8) {
            int r6 = r7.length();
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L17;
            char r2 = r7.charAt(r1);
            if (r2 != '\t') goto L7;
        L12:
            boolean r3 = true;
        L13:
            if (r3 == false) goto L16;
            r1 = r1 + 1;
            goto L3
        L16:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(r2), Integer.valueOf(r1), r8, r7}).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            if (' ' > r2) goto L11;
            if ('~' >= r2) goto L12;
        L11:
            r3 = false;
            goto L13
        }

        private final String get(String[] r5, String r6) {
            IntProgression r4 = RangesKt.step(RangesKt.downTo(r5.length - 2, 0), 2);
            int r0 = r4.getFirst();
            int r1 = r4.getLast();
            int r7 = r4.getStep();
            if (r7 < 0) goto L6;
            if (r0 <= r1) goto L8;
            return null;
        L8:
            if (StringsKt.equals(r6, r5[r0], true) == true) goto L10;
            if (r0 == r1) goto L19;
            r0 = r0 + r7;
            goto L8
        L19:
            return null;
        L10:
            return r5[r0 + 1];
        L6:
            if (r0 >= r1) goto L8;
            return null;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function moved to extension", replaceWith = @ReplaceWith(expression = "headers.toHeaders()", imports = {}))
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m2962deprecated_of(Map<String, String> r3) {
            Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "headers");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).of(r4);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function name changed", replaceWith = @ReplaceWith(expression = "headersOf(*namesAndValues)", imports = {}))
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m2963deprecated_of(String... r3) {
            Intrinsics.checkParameterIsNotNull(r3, "namesAndValues");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).of((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), String[].class, "com.obric.memorydata.plugin"));
        }

        @JvmStatic
        public final Headers of(Map<String, String> r9) {
            Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r10, "$this$toHeaders");
            String[] r1 = new String[r10.size() * 2];
            Iterator r11 = r10.entrySet().iterator();
            int r3 = 0;
        L4:
            if (r11.hasNext() == false) goto L15;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
            String r6 = (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L13;
            String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            if (r6 == null) goto L11;
            String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).checkName(r7);
            ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).checkValue(r8, r7);
            r1[r3] = r7;
            r1[r3 + 1] = r8;
            r3 = r3 + 2;
            goto L4
        L11:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        L13:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        L15:
            return new Headers(r1, null);
        }

        @JvmStatic
        public final Headers of(String... r10) {
            Intrinsics.checkParameterIsNotNull(r10, "namesAndValues");
            if ((r10.length % 2) != 0) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == false) goto L37;
            Object r11 = r10.clone();
            if (r11 == null) goto L35;
            String[] r12 = (String[]) ZeusTransformUtils.preCheckCast(r11, String[].class, "com.obric.memorydata.plugin");
            int r2 = r12.length;
            int r6 = 0;
        L11:
            if (r6 >= r2) goto L24;
            if (r12[r6] == null) goto L15;
            boolean r7 = true;
        L16:
            if (r7 == false) goto L23;
            String r8 = r12[r6];
            if (r8 == null) goto L21;
            r12[r6] = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            r6 = r6 + 1;
            goto L11
        L21:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        L23:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Headers cannot be null".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L15:
            r7 = false;
            goto L16
        L24:
            IntProgression r3 = RangesKt.step((IntProgression) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r12.length), IntProgression.class, "com.obric.memorydata.plugin"), 2);
            int r4 = r3.getFirst();
            int r5 = r3.getLast();
            int r9 = r3.getStep();
            if (r9 < 0) goto L28;
            if (r4 <= r5) goto L29;
        L33:
            return new Headers(r12, null);
        L29:
            String r13 = r12[r4];
            String r14 = r12[r4 + 1];
            ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).checkName(r13);
            ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).checkValue(r14, r13);
            if (r4 == r5) goto L33;
            r4 = r4 + r9;
            goto L29
        L28:
            if (r4 < r5) goto L33;
        L35:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        L37:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Expected alternating header names and values".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r1 = false;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    private Headers(String[] r1) {
        this.namesAndValues = r1;
    }

    public /* synthetic */ Headers(String[] r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @JvmStatic
    public static final Headers of(Map<String, String> r2) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return Companion.of(r3);
    }

    @JvmStatic
    public static final Headers of(String... r1) {
        return Companion.of(r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m2961deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] r0 = this.namesAndValues;
        long r1 = r0.length * 2;
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1 = r1 + ((long) this.namesAndValues[r3].length());
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Headers.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(this.namesAndValues, ((Headers) ZeusTransformUtils.preCheckCast(r3, Headers.class, "com.obric.memorydata.plugin")).namesAndValues) == false) goto L7;
        return true;
    }

    public final String get(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, ActivityLifecycle.NAME);
        return Companion.access$get(Companion, this.namesAndValues, r2);
    }

    public final Date getDate(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, ActivityLifecycle.NAME);
        String r1 = get(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return DatesKt.toHttpDateOrNull(r1);
    }

    public final Instant getInstant(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, ActivityLifecycle.NAME);
        Date r1 = getDate(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.toInstant();
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int r0 = size();
        Pair[] r1 = new Pair[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = TuplesKt.to(name(r2), value(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return ArrayIteratorKt.iterator(r1);
    }

    public final String name(int r1) {
        return this.namesAndValues[r1 * 2];
    }

    public final Set<String> names() {
        TreeSet r0 = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int r1 = size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(name(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        Set<String> r4 = Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r4, "Collections.unmodifiableSet(result)");
        return r4;
    }

    public final Builder newBuilder() {
        Builder r0 = new Builder();
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0.getNamesAndValues$okhttp(), Collection.class, "com.obric.memorydata.plugin"), this.namesAndValues);
        return r0;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap r0 = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int r1 = size();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L14;
        String r4 = name(r2);
        Locale r5 = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(r5, "Locale.US");
        if (r4 == null) goto L12;
        String r6 = r4.toLowerCase(r5);
        Intrinsics.checkExpressionValueIsNotNull(r6, "(this as java.lang.String).toLowerCase(locale)");
        List r7 = (List) ZeusTransformUtils.preCheckCast(r0.get(r6), List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(2), List.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r6, r7);
    L10:
        r7.add(value(r2));
        r2 = r2 + 1;
        goto L4
    L12:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L14:
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.append(name(r2));
        r0.append(": ");
        r0.append(value(r2));
        r0.append("\n");
        r2 = r2 + 1;
        goto L3
    L5:
        String r4 = r0.toString();
        Intrinsics.checkExpressionValueIsNotNull(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    }

    public final String value(int r1) {
        return this.namesAndValues[(r1 * 2) + 1];
    }

    public final List<String> values(String r7) {
        Intrinsics.checkParameterIsNotNull(r7, ActivityLifecycle.NAME);
        List r0 = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
        int r1 = size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L10;
        if (StringsKt.equals(r7, name(r3), true) == false) goto L9;
        if (r0 != null) goto L8;
        r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(2), List.class, "com.obric.memorydata.plugin");
    L8:
        r0.add(value(r3));
    L9:
        r3 = r3 + 1;
        goto L3
    L10:
        if (r0 == null) goto L13;
        List<String> r6 = Collections.unmodifiableList(r0);
        Intrinsics.checkExpressionValueIsNotNull(r6, "Collections.unmodifiableList(result)");
        return r6;
    L13:
        return CollectionsKt.emptyList();
    }
}
