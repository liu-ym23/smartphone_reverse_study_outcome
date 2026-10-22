package com.obric.capabilitykit.entity;

import android.net.Uri;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/UriTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Landroid/net/Uri;", "()V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", EventBody.KEY_VALUE, "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UriTypeAdapter extends TypeAdapter<Uri> {
    public UriTypeAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Uri read(JsonReader r1) {
        Intrinsics.checkNotNullParameter(r1, "input");
        return Uri.parse(r1.nextString());
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Uri read(JsonReader r1) {
        return read(r1);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r1, Uri r2) {
        Intrinsics.checkNotNullParameter(r1, "out");
        if (r2 == null) goto L5;
        String r0 = r2.toString();
    L6:
        r1.value(r0);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.google.gson.TypeAdapter
    public /* synthetic */ void write(JsonWriter r3, Uri r4) {
        write2(r3, (Uri) ZeusTransformUtils.preCheckCast(r4, Uri.class, "com.obric.memorydata.plugin"));
    }
}
