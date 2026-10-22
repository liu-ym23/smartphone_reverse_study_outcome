package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaComponent {

    public static abstract class Ref {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public String _handle;
        private volatile SchemaComponent _schemaComponent;
        private SchemaTypeSystem _schemaTypeSystem;

        static {
        }

        public Ref(SchemaComponent r3) {
            this._schemaComponent = (SchemaComponent) ZeusTransformUtils.wrapperContextForParams(r3, SchemaComponent.class, "com.obric.memorydata.plugin");
        }

        public Ref(SchemaTypeSystem r3, String r4) {
            this._schemaTypeSystem = (SchemaTypeSystem) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeSystem.class, "com.obric.memorydata.plugin");
            this._handle = r4;
        }

        public final SchemaComponent getComponent() {
            if (this._schemaComponent != null) goto L18;
            if (this._handle == null) goto L18;
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L8:
            if (this._schemaComponent != null) goto L12;
            String r0 = this._handle;     // Catch: Throwable -> L14
            if (r0 == null) goto L12;
            this._schemaComponent = this._schemaTypeSystem.resolveHandle(r0);     // Catch: Throwable -> L14
            this._schemaTypeSystem = null;     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);     // Catch: Throwable -> L14
        L18:
            return this._schemaComponent;
        }
    }

    QName getName();
}
