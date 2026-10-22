package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AudioManifest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<AudioSegment> segments;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AudioManifest() {
    }
}
