package com.obric.capabilitykit.entity;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/UriTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Landroid/net/Uri;", "()V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class UriTypeAdapter extends TypeAdapter<Uri> {
    public UriTypeAdapter() {
    }

    public Uri read(JsonReader r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return UriProtector.parse(r2.nextString());
    }

    /* JADX INFO: renamed from: read, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m16read(JsonReader r1) {
        return read(r1);
    }

    public void write(JsonWriter r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "out");
        if (r3 == null) goto L5;
        String r4 = r3.toString();
    L6:
        r2.value(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Object r2) {
        write(r1, (Uri) r2);
    }
}
