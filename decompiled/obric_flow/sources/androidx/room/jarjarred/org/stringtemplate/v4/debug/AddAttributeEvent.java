package androidx.room.jarjarred.org.stringtemplate.v4.debug;

/* JADX INFO: loaded from: classes.dex */
public class AddAttributeEvent extends ConstructionEvent {
    String name;
    Object value;

    public AddAttributeEvent(String r5, Object r10) {
        this.name = r5;
        this.value = r10;
    }

    public String toString() {
        return "addEvent{, name='" + this.name + "', value=" + this.value + ", location=" + getFileName() + ":" + getLine() + '}';
    }
}
