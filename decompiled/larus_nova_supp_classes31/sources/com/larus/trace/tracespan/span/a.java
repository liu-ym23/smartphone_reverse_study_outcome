package com.larus.trace.tracespan.span;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements b {
    @Override // com.larus.trace.tracespan.span.b
    public final String a() {
        return "empty";
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void c(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void cancel(boolean r1) {
    }

    @Override // com.larus.trace.tracespan.span.b
    public final b d(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        return this;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void e(b r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String f() {
        return "empty";
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void g(Integer r1, String r2) {
    }

    @Override // com.larus.trace.tracespan.span.b
    public final b getParent() {
        return null;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String getTag() {
        return "empty";
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String getTraceId() {
        return "empty";
    }

    @Override // com.larus.trace.tracespan.span.b
    public final boolean hasEnd() {
        return true;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void setTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    public a() {
    }
}
